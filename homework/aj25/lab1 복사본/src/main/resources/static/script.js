const csvFiles = {
    volcano: "data/volcano.csv",
    tornado: "data/tornado.csv",
    typhoon: "data/typhoon.csv",
    tsunami: "data/tsunami.csv"
};

const disasterData = {};

function loadCSVData() {
    Object.keys(csvFiles).forEach(disaster => {
        fetch(csvFiles[disaster])
            .then(response => response.text())
            .then(csv => {
                Papa.parse(csv, {
                    header: true,
                    skipEmptyLines: true,
                    complete: function(results) {
                        disasterData[disaster] = results.data;
                        console.log(`${disaster} data loaded:`, disasterData[disaster]);  // 데이터 확인
                    }
                });
            })
            .catch(err => console.error(`${disaster} CSV 로딩 실패:`, err));
    });
}


// 페이지 로드 시 localStorage 확인하여 해당 disaster로 초기화
document.addEventListener("DOMContentLoaded", () => {
    loadCSVData();
    
    // 자연재해 클릭 시 해당 화면으로 이동
    document.getElementById('volcano')?.addEventListener('click', () => onLinkClick("volcano"));
    document.getElementById('tornado')?.addEventListener('click', () => onLinkClick("tornado"));
    document.getElementById('typhoon')?.addEventListener('click', () => onLinkClick("typhoon"));
    document.getElementById('tsunami')?.addEventListener('click', () => onLinkClick("tsunami"));
  
    // "Natural Disaster Archive" 클릭 시 메인 페이지로 초기화
    document.getElementById('title')?.addEventListener('click', () => {
        document.getElementById('disaster-image').src = "images/natural-disaster.jpg";
        document.querySelector('.table-title').innerText = "";
        document.querySelector('.tbody').innerHTML = "";
        localStorage.removeItem("selectedDisaster");
    
        // focus 클래스 제거
        ['volcano', 'tornado', 'tsunami', 'typhoon'].forEach(id => {
            document.getElementById(id)?.classList.remove('focus');
        });
    });
  
    // 새로 고침 시 저장된 상태 복원
    const savedDisaster = localStorage.getItem("selectedDisaster");
    if (savedDisaster && disasterData[savedDisaster]) {
        makePage(savedDisaster);
        document.getElementById(savedDisaster)?.classList.add('focus');
    }
});

function onLinkClick(disaster) {
    ['volcano', 'tornado', 'tsunami', 'typhoon'].forEach(id => {
        document.getElementById(id)?.classList.toggle('focus', id === disaster);
    });
  
    localStorage.setItem("selectedDisaster", disaster);
    makePage(disaster);
}

function makePage(disaster) {
    document.getElementById('title').innerText = "Natural Disaster Archive";
    document.getElementById('disaster-image').src = `images/${disaster}.jpg`;
    document.querySelector('.table-title').innerText = disaster.charAt(0).toUpperCase() + disaster.slice(1);

    const tbody = document.querySelector('.tbody');
    tbody.innerHTML = "";

    if (!disasterData[disaster]) return;

    makeTable(disasterData[disaster]);
}

function makeTable(arr, disaster) {
    const tbody = document.querySelector('.tbody');
    tbody.innerHTML = "";
  
    arr.forEach(item => {
      const tr = document.createElement('tr');
  
      if (disaster === 'tornado') {
        tr.innerHTML = `
          <td>${item.om || ''}</td>
          <td>${item.yr || ''}</td>
          <td>${item.mo || ''}</td>
          <td>${item.dy || ''}</td>
          <td>${item.datetime_utc || ''}</td>
          <td>${item.mag || ''}</td>
          <td>${item.inj || ''}</td>
          <td>${item.fat || ''}</td>
          <td>${item.loss || ''}</td>
        `;
      } else if (disaster === 'tsunami') {
        tr.innerHTML = `
          <td>${item.ID || ''}</td>
          <td>${item.YEAR || ''}</td>
          <td>${item.MONTH || ''}</td>
          <td>${item.DAY || ''}</td>
          <td>${item.HOUR || ''}</td>
          <td>${item.LATITUDE || ''}</td>
          <td>${item.LONGITUDE || ''}</td>
          <td>${item.LOCATION_NAME || ''}</td>
          <td>${item.COUNTRY || ''}</td>
          <td>${item.CAUSE || ''}</td>
          <td>${item.TS_INTENSITY || ''}</td>
          <td>${item.DAMAGE_TOTAL_DESCRIPTION || ''}</td>
        `;
      } else if (disaster === 'typhoon') {
        tr.innerHTML = `
          <td>${item.ID || ''}</td>
          <td>${item.Name || ''}</td>
          <td>${item.Date || ''}</td>
          <td>${item.Time || ''}</td>
          <td>${item.Event || ''}</td>
          <td>${item.Status || ''}</td>
          <td>${item.Latitude || ''}</td>
          <td>${item.Longitude || ''}</td>
          <td>${item['Maximum Wind'] || ''}</td>
          <td>${item['Minimum Pressure'] || ''}</td>
        `;
      } else if (disaster === 'volcano') {
        tr.innerHTML = `
          <td>${item.Name || ''}</td>
          <td>${item.Location || ''}</td>
          <td>${item.Country || ''}</td>
          <td>${item.Latitude || ''}</td>
          <td>${item.Longitude || ''}</td>
          <td>${item['Elevation (m)'] || ''}</td>
          <td>${item.Type || ''}</td>
          <td>${item.VEI || ''}</td>
          <td>${item.Deaths || ''}</td>
          <td>${item['Damage ($Mil)'] || ''}</td>
        `;
      }
  
      tbody.appendChild(tr);
    });
}
  

