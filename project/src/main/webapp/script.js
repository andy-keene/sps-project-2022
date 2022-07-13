// Copyright 2020 Google LLC
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
 * Adds a message to main page to the page.
 */
function addMessage() {
    // Add it to the page.
    const greetingContainer = document.getElementById('greeting-container');
    greetingContainer.innerText = "Stop clicking buttons and get to work!";
}


async function processForm() {
    // Class documentation at:
    // https://developer.mozilla.org/en-US/docs/Web/API/FormData/FormData
    const formElement = document.getElementById('user-form-data');
    const form = new FormData(formElement);

    // Use FormData() object to easily parse form input to JSON
    const resource = {
        name: form.get("name"),
        date: form.get("date"),
        availability: form.get("availability")
    };

    // We need to encode the resource data as a string for our HTTP POST request
    // and for printing to the console. 
    const resourceJson = JSON.stringify(resource);


    const response = await fetch("/resources", {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: resourceJson
    });

    console.log("Posted data: " + resourceJson);
    console.log("Posted resource, response: " + resourceJson);
}


async function fetchResources() {
    const response = await fetch('/resources');
    const resources = await response.json();

    // JSON.stringify() can be used to pretty-print data
    const jsonContainer = document.getElementById('fetch-resources-result').innerText = JSON.stringify(resources, null, 2);
}
