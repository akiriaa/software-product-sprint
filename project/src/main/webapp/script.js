window.onload = function() {
  addResults();
  
};

// Adds map to page
/*var map;
function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: -19.0154, lng: 29.1549},
    zoom: 0
  });
*/
   
async function addResults(){

   // Sends a request to /my-data-url 
   fetch('/data')
   // Parses the response as JSON  
.then(response => response.json()) 
  // References the fields in the object 
.then((resultsFinal) => { 
  console.log(resultsFinal);

  const resultsContainer = document.getElementById('results');
  
  resultsContainer.innerHTML = resultsFinal.join("<br>");
});
}