// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomQuote() {
  const quotes =
      ['I like that boulder. That is a nice boulder.', 'I bet you have never seen a donkey fly!', 'She called me a noble steed.', 'Better out than in, I always say.'];

  // Pick a random greeting.
  const quote = quotes[Math.floor(Math.random() * quotes.length)];

  // Add it to the page.
  const quoteContainer = document.getElementById('quote-container');
  quoteContainer.innerText = quote;
}



var slideIndex = 1;
showSlides(slideIndex);

    // Next/previous controls
function plusSlides(n) {
    showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    if (n > slides.length) {
        slideIndex = 1
    }
    if (n < 1) {
            slideIndex = slides.length
    }
    for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
    }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
}


/**
 * The above code is organized to show each individual step, but we can use an
 * ES6 feature called arrow functions to shorten the code. This function
 * combines all of the above code into a single Promise chain. You can use
 * whichever syntax makes the most sense to you.
 */
function getRandomQuoteUsingArrowFunctions() {
  fetch('/random-quote').then(response => response.text()).then((quote) => {
    document.getElementById('quote-container').innerText = quote;
  });
}

/**
 * Another way to use fetch is by using the async and await keywords. This
 * allows you to use the return values directly instead of going through
 * Promises.
 */
async function getRandomQuoteUsingAsyncAwait() {
  const response = await fetch('/random-quote');
  const quote = await response.text();
  document.getElementById('quote-container').innerText = quote;
}
