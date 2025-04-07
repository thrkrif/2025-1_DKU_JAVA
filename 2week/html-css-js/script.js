var vitamins = [{"vname":"Biotin","what":"Energy storage/Protein, carbohydrate, and fat metabolism","where":"Avocados/Cauliflower/Eggs/Fruits (e.g., raspberries)/Liver/Pork/Salmon/Whole grains","daily":"30 mcg"},
    {"vname":"Choline","what":"Brain development/Cell signaling/Lipid (fat) transport and metabolism/Liver function/Muscle movement/Nerve function/Normal metabolism","where":"Avocados/Cauliflower/Eggs/Fruits (e.g., raspberries)/Liver/Pork/Salmon/Whole grains","daily":"550 mg"},
    {"vname":"Folate/Folic Acid","what":"Prevention of birth defects/Protein metabolism/Red blood cell formation","where":"Asparagus/Avocados/Beans and peas/Enriched grain products (e.g., bread,cereal, pasta, rice)/Green leafy vegetables(e.g., spinach)/Oranges and orange juice","daily":"400 mcg DFE**"},
    {"vname":"Niacin","what":"Cholesterol production/Conversion of food into energy/Digestion/Nervous system function","where":"Beans/Beef/Enriched grain products (e.g., bread, cereal, pasta, rice)/Nuts/Pork/Poultry/Seafood/Whole grains","daily":"16 mg**"},
    {"vname":"Pantothenic Acid","what":"Conversion of food into energy/Fat metabolism/Hormone production/Nervous system function/Red blood cell formation","where":"Avocados/Beans and peas/Broccoli/Eggs/Milk/Mushrooms/Poultry/Seafood/Sweet potatoes/Whole grains/Yogurt","daily":"5 mg"},
    {"vname":"Riboflavin","what":"Conversion of food into energy/Growth and development/Red blood cell formation","where":"Eggs/Enriched grain products (e.g., bread, cereal, pasta, rice)/Meat/Milk/Mushrooms/Poultry/Seafood (e.g., oysters)/Spinach","daily":"1.3 mg"},
    {"vname":"Thiamin","what":"Conversion of food into energy/Nervous system function","where":"Beans and peas/Enriched grain products (e.g., bread, cereal, pasta, rice)/Nuts/Pork/Sunflower seeds/Whole grains","daily":"1.2 mg"},
    {"vname":"Vitamin A","what":"Growth and development/Immune function/Red blood cell formation/Reproduction/Skin and bone formation/Vision","where":"Cantaloupe/Carrots/Dairy products/Eggs/Fortified cereals/Green leafy vegetables (e.g., spinach and broccoli)/Pumpkin/Red peppers/Sweet potatoes","daily":"900 mcg**"},
    {"vname":"Vitamin B6","what":"Immune function/Nervous system function/Protein, carbohydrate, and fat metabolism/Red blood cell formation","where":"hickpeas/Fruits (other than citrus)/Potatoes/Salmon/Tuna","daily":"1.7 mg"},
    {"vname":"Vitamin B12","what":"Conversion of food into energy/Nervous system function/Red blood cell formation","where":"Dairy products/Eggs/Fortified cereals/Meat/Poultry/Seafood (e.g., clams, trout, salmon, haddock, tuna)","daily":"2.4 mcg"},
    {"vname":"Vitamin C","what":"Antioxidant/Collagen and connective tissue formation/Immune function/Wound healing","where":"Fruit (e.g., cantaloupe, citrus fruits, kiwifruit, and strawberries)/Juices (e.g., oranges, grapefruit, and tomato)/Vegetables (e.g., broccoli, Brussels sprouts, peppers, and tomatoes)","daily":"90 mg"},
    {"vname":"Vitamin D","what":"Nutrient to get more of/Blood pressure regulation/Bone growth/Calcium balance/Hormone production/Immune function/Nervous system function","where":"Eggs/Fish (e.g., herring, mackerel, salmon, trout, and tuna)/Fish oil and cod liver oil/Fortified dairy products/Fortified margarine/Fortified orange juice/Fortified plant-based beverages (e.g., soy, rice, and almond)/Fortified ready-to-eat cereals/Mushrooms/Pork","daily":"20 mcg**"},
    {"vname":"Vitamin E","what":"Antioxidant/Formation of blood vessels/Immune function","where":"Fortified cereals and juices/Green vegetables (e.g., spinach and broccoli)/Nuts and seeds/Peanuts and peanut butter/Vegetable oils","daily":"15 mg**"},
    {"vname":"Vitamin K","what":"Blood clotting/Strong bones","where":"Green vegetables(e.g., broccoli, kale, spinach, turnip greens, collard greens, Swiss chard, mustard greens)","daily":"120 mcg"}]
var minerals = [{"vname":"Calcium","what":"Blood clotting/Bone and teeth formation/Constriction and relaxation of blood vessels/Hormone secretion/Muscle contraction/Nervous system function","where":"Canned seafood with bones(e.g., salmon and sardines)/Dairy products/Fortified orange juice/Fortified plant-based beverages (e.g., soy, rice, and almond)/Fortified ready-to-eat cereals/Green vegetables (e.g., kale,broccoli, and collard greens)/Tofu (made with calcium sulfate)","daily":"1,300 mg"},
    {"vname":"Chloride","what":"Acid-base balance/Conversion of food intoenergy/Digestion/Fluid balance/Nervous system function","where":"Olives/Rye/Salt substitutes/Seaweeds (e.g., dulse and kelp)/Table salt and sea salt/Vegetables (e.g., celery, lettuce, and tomatoes)","daily":"2,300 mg"},
    {"vname":"Chromium ","what":"Insulin function/Protein, carbohydrate, and fat metabolism","where":"Broccoli/Fruits (e.g., apples and bananas)/Juices (e.g., grape and orange)/Meat/Spices (e.g., garlic and basil)/Turkey/Whole grains","daily":"35 mcg"},
    {"vname":"Copper ","what":"Antioxidant/Bone formation/Collagen and connective tissue formation/Energy production/Iron metabolism/Nervous system function","where":"Chocolate and cocoa/Crustaceans and shellfish/Lentils/Nuts and seeds/Organ meats (e.g., liver)/Whole grains","daily":"0.9 mg"},
    {"vname":"Iodine","what":"Growth and development/Metabolism/Reproduction/Thyroid hormone production","where":"Breads and cereals/Dairy products/Iodized salt/Potatoes/Seafood/Seaweed/Turkey","daily":"150 mcg"},
    {"vname":"Iron","what":"Nutrient to get more of/Energy production/Growth and development/Immune function/Red blood cell formation/Reproduction/Wound healing","where":"Beans/Eggs/Fruits (e.g., raisins and prunes)/Green vegetables (e.g., spinach,kale, broccoli, and collard greens)/Meat/Nuts/Organ meats (e.g., liver)/Peas/Poultry/Seafood (e.g., tuna, sardines,haddock, shrimp, and oysters)/Seeds/Soy products (e.g., tofu)/Whole grain, enriched, and fortified breads, cereals, pasta, and rice","daily":"18 mg"},
    {"vname":"Magnesium","what":"Blood pressure regulation/Blood sugar regulation/Bone formation/Energy production/Hormone secretion/Immune function/Muscle contraction/Nervous system function/Normal heart rhythm/Protein formation","where":"Avocados/Beans and peas/Dairy products/Fruits (e.g., bananas and raisins)/Green leafy vegetables (e.g.,spinach)/Nuts and pumpkin seeds/Potatoes/Whole grains","daily":"420 mg"},
    {"vname":"Manganese","what":"Carbohydrate, protein, and cholesterol metabolism/Cartilage and bone formation/Wound healing","where":"Beans/Nuts/Pineapple/Spinach/Sweet potato/Whole grains","daily":"2.3 mg"},
    {"vname":"Molybdenum","what":"Enzyme production","where":"/Beans and peas/Nuts/Whole grains","daily":"45 mcg"},
    {"vname":"Phosphorus","what":"Acid-base balance/Bone formation/Energy production and storage/Hormone activation","where":"Beans and peas/Dairy products/Meat/Nuts and seeds/Poultry/Seafood/Whole grain, enriched, and fortified cereals and breads","daily":"1,250 mg"},
    {"vname":"Potassium","what":"Nutrient to get more of/Blood pressure regulation/Carbohydrate metabolism/Fluid balance/Growth and development/Heart function/Muscle contraction/Nervous system function/Protein formation","where":"Beans/Dairy products (e.g., milk and yogurt)/Fruits (e.g., bananas, dried apricots, and stewed prunes)/Juices (e.g., carrot and other vegetable juices, orange, pomegranate, and prune)/Seafood (e.g., clams and salmon)/Tomato products/Vegetables (e.g., potatoes, sweet potatoes, beet greens, and spinach)","daily":"4,700 mg"},
    {"vname":"Selenium","what":"Antioxidant/Immune function/Reproduction/Thyroid function","where":"Eggs/Enriched pasta and rice/Meat/Nuts (e.g., Brazil nuts) and seeds/Poultry/Seafood/Whole grains","daily":"55 mcg"},
    {"vname":"Sodium","what":"Nutrient to get less of/Acid-base balance/Blood pressure regulation/Fluid balance/Muscle contraction/Nervous system function","where":"Breads and rolls/Burritos and tacos/Cheese/Chicken/Cold cuts and cured meats/Egg dishes and omelets/Pizza/Sandwiches (e.g., hamburgers, hot dogs, and submarine sandwiches)/Snack foods (e.g., chips, crackers, microwave popcorn, and pretzels)/Soups","daily":"2,300 mg"},
    {"vname":"Zinc","what":"Growth and development/Immune function/Nervous/Protein formation/Reproduction/Taste and smell/Wound healing","where":"Beans and peas/Beef/Dairy products/Fortified cereals/Nuts/Poultry/Shellfish/Whole grains","daily":"11 mg"}]

document.addEventListener("DOMContentLoaded", () => {
    makePage(true);

    document.getElementById('vitamins').addEventListener('click', () => onLinkClick("vitamins"));
    document.getElementById('minerals').addEventListener('click', () => onLinkClick("minerals"));
});

function onLinkClick(id) {
    document.getElementById('vitamins').classList.toggle('focus', id === "vitamins");
    document.getElementById('minerals').classList.toggle('focus', id === "minerals");

    makePage(id === "vitamins");
}

function makePage(isVitamins) {
    document.getElementById('title').innerHTML = "Vitamins and Minerals";
    const tbody = document.querySelector('.tbody');
    tbody.innerHTML = "";  // Clears existing table rows more efficiently

    document.querySelector('.table-title').innerText = isVitamins ? 'Vitamin' : 'Mineral';
    makeTable(isVitamins ? vitamins : minerals);
}

function makeTable(arr) {
    const tbody = document.querySelector('.tbody');

    arr.forEach(item => {
        const tr = document.createElement('tr');

        tr.innerHTML = `
            <td>${item.vname}</td>
            <td><ul>${item.what.split('/').map(w => `<li>${w}</li>`).join('')}</ul></td>
            <td><ul>${item.where.split('/').map(w => `<li>${w}</li>`).join('')}</ul></td>
            <td>${item.daily}</td>
        `;

        tbody.appendChild(tr);
    });
}
