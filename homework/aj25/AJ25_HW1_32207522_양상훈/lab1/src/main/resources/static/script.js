// 각 자연재해에 대한 csv 파일의 경로를 저장한 객체
const csvFiles = {
    volcano: "data/volcano.csv",
    tornado: "data/tornado.csv",
    typhoon: "data/typhoon.csv",
    tsunami: "data/tsunami.csv"
};
// 재해 데이터를 저장할 객체
const disasterData = {};
// CSV 데이터를 비동기적으로 불러와서 처리하는 함수
function loadCSVData(callback) {
    let filesLoaded = 0; // 로딩 완료된 파일의 개수
    const totalFiles = Object.keys(csvFiles).length; // 총 파일 개수

    Object.keys(csvFiles).forEach(disaster => {
        fetch(csvFiles[disaster]) // csv 파일 가져오기
            .then(response => response.text()) // 가져온 csv파일을 텍스트(문자열)로 변환
            .then(csv => { // csv 파일을 papaParse를 이용하여 파싱하고 JS 객체 배열로 변환할 것임
                Papa.parse(csv, {
                    header: true, // 첫 줄은 헤더(열 이름)로 이용
                    skipEmptyLines: true, // 빈 줄 무시 
                    complete: function(results) {
                        disasterData[disaster] = results.data; 
                        console.log(`${disaster} data loaded:`, disasterData[disaster]);  // 데이터 확인
                        filesLoaded++;
                        // 모든 CSV 파일이 다 로딩된 후에 테이블을 그리도록 하기 위함.
                        if (filesLoaded === totalFiles && callback) {
                            callback();  // 모든 파일이 로드되었으면 callback 호출
                        }
                    }
                });
            })
            .catch(err => console.error(`${disaster} CSV 로딩 실패:`, err));
    });
}

// 페이지 로드 시 localStorage 확인하여 해당 disaster로 초기화
document.addEventListener("DOMContentLoaded", () => {
    loadCSVData(() => {
        // CSV 파일이 모두 로드 되면 실행할 것임.
        const savedDisaster = localStorage.getItem("selectedDisaster");
        if (savedDisaster && disasterData[savedDisaster]) {
            makePage(savedDisaster);
            document.getElementById(savedDisaster)?.classList.add('focus'); // focus 클래스를 추가함. 해당 ID 없으면 넘어감(?. : 옵셔널 체이닝)
        }
    });

    // 자연재해 클릭 시 해당 화면으로 이동
    document.getElementById('volcano')?.addEventListener('click', () => onLinkClick("volcano"));
    document.getElementById('tornado')?.addEventListener('click', () => onLinkClick("tornado"));
    document.getElementById('typhoon')?.addEventListener('click', () => onLinkClick("typhoon"));
    document.getElementById('tsunami')?.addEventListener('click', () => onLinkClick("tsunami"));
    // title 클릭시 처음 기본 화면   
    document.getElementById('title')?.addEventListener('click', () => onTitleClick());
        

});


function onLinkClick(disaster) {
    ['volcano', 'tornado', 'tsunami', 'typhoon'].forEach(id => {
        document.getElementById(id)?.classList.toggle('focus', id === disaster);
    });
    
    localStorage.setItem("selectedDisaster", disaster);
    makePage(disaster);
}

// Natural Disaster Archive를 클릭하면 초기 화면으로 이동함.
function onTitleClick() {
    document.querySelector(".main-image").src = "images/natural-disaster.jpg";
    document.querySelector(".table-title").textContent = "";
    document.querySelector(".thead").innerHTML = ""; // 헤더 비움
    document.querySelector(".tbody").innerHTML = ""; // 데이터 비움
    localStorage.removeItem("selectedDisaster"); // 재해 선택한 스토리지를 비움(메인 화면으로 간 경우 이전 데이터 초기화 시킴)

    // focus 클래스 제거
    ['volcano', 'tornado', 'tsunami', 'typhoon'].forEach(id => {
        document.getElementById(id)?.classList.remove('focus');
    });
}

function makePage(disaster) {
    // document.getElementById('title').innerText = "Natural Disaster Archive"; 굳이 작성 안해도 됨
    document.getElementById('disaster-image').src = `images/${disaster}.jpg`; // 이미지 설정
    document.querySelector('.table-title').innerText = disaster.charAt(0).toUpperCase() + disaster.slice(1); // 테이블 이름 설정, 첫 글자 대문자 변환
    
    const tbody = document.querySelector('.tbody');
    tbody.innerHTML = "";
    
    
    if (!disasterData[disaster]) return; // 데이터가 존재하지 않으면 종료
    
    makeTable(disasterData[disaster], disaster);
}

function makeTable(arr, disaster) {
    const tbody = document.querySelector('.tbody');
    tbody.innerHTML = "";
    
    
    const thead = document.querySelector('.thead');
    thead.innerHTML = "";  
    
    // disaster에 따라 header가 다름
    let headers = [];
 
    if (disaster === 'tornado') {
        headers = ["Year", "Month", "Day", "Date Time (UTC)", "Magnitude", "Injuries", "Fatalities", "Loss"];
    } else if (disaster === 'tsunami') {
        headers = ["ID", "Year", "Month", "Day", "Hour", "Latitude", "Longitude", "Location", "Country", "Cause", "Intensity", "Total Damage Description"];
    } else if (disaster === 'typhoon') {
        headers = ["ID", "Name", "Date", "Time", "Status", "Latitude", "Longitude", "Max Wind", "Min Pressure"];
    } else if (disaster === 'volcano') {
        headers = ["Year", "Volcano Name", "Location", "Country", "Lat / Long", "Type", "VEI", "Total Deaths"];
    }
    
    // tr 요소를 생성, 각 헤더 항목을 th로 만들어서 thead에 추가한다.
    const trHeader = document.createElement('tr');
    headers.forEach(header => {
        const th = document.createElement('th');
        th.innerText = header;
        trHeader.appendChild(th);
    });
    thead.appendChild(trHeader);
    // 각각의 데이터를 테이블에 추가한다.
    // item 객체에서 해당 데이터를 가져와 td에 채워넣는다. 데이터가 없는 경우 'N/A' 로 표시한다.
    arr.forEach(item => {
      const tr = document.createElement('tr');
  
      if (disaster === 'tornado') {
        tr.innerHTML = `
        <td>${item.yr || 'N/A'}</td>               
        <td>${item.mo || 'N/A'}</td>               
        <td>${item.dy || 'N/A'}</td>               
        <td>${item.datetime_utc || 'N/A'}</td>     
        <td>${item.mag || 'N/A'}</td>              
        <td>${item.inj || 'N/A'}</td>              
        <td>${item.fat || 'N/A'}</td>              
        <td>${item.loss || 'N/A'}</td>             
        `;
      } else if (disaster === 'tsunami') {
        tr.innerHTML = `
          <td>${item.ID || 'N/A'}</td>
          <td>${item.YEAR || 'N/A'}</td>
          <td>${item.MONTH || 'N/A'}</td>
          <td>${item.DAY || 'N/A'}</td>
          <td>${item.HOUR || 'N/A'}</td>
          <td>${item.LATITUDE || 'N/A'}</td>
          <td>${item.LONGITUDE || 'N/A'}</td>
          <td>${item.LOCATION_NAME || 'N/A'}</td>
          <td>${item.COUNTRY || 'N/A'}</td>
          <td>${item.CAUSE || 'N/A'}</td>
          <td>${item.TS_INTENSITY || 'N/A'}</td>
          <td>${item.DAMAGE_TOTAL_DESCRIPTION || 'N/A'}</td>
        `;
      } else if (disaster === 'typhoon') {
        tr.innerHTML = `
          <td>${item.ID || 'N/A'}</td>
          <td>${item.Name || 'N/A'}</td>
          <td>${item.Date || 'N/A'}</td>
          <td>${item.Time || 'N/A'}</td>
          <td>${item.Status || 'N/A'}</td>
          <td>${item.Latitude || 'N/A'}</td>
          <td>${item.Longitude || 'N/A'}</td>
          <td>${item['Maximum Wind'] || 'N/A'}</td>
          <td>${item['Minimum Pressure'] || 'N/A'}</td>
        `;
      } else if (disaster === 'volcano') {
        tr.innerHTML = `
          <td>${item.Year || 'N/A'}</td> 
          <td>${item.Name || 'N/A'}</td>
          <td>${item.Location || 'N/A'}</td>
          <td>${item.Country || 'N/A'}</td>
          <td>${item.Latitude && item.Longitude ? `${item.Latitude} / ${item.Longitude}` : 'N/A'}</td>
          <td>${item.Type || 'N/A'}</td>
          <td>${item.VEI || 'N/A'}</td>
          <td>${item.Deaths || 'N/A'}</td>
        `;
      }
  
      tbody.appendChild(tr);
    });
}
  

