function addMessage() {
  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = "Stop clicking buttons and get to work!";
}

var test = [
    {
        organizerName: "team 33",
        organizerEmail: "sps-team33@gmail.com",
        eventName: "team kickoff",
        eventDate: "07/25/2022 08:00:00AM",
        ageGroup: "10th Grade",
        location: "Online",
        link: "http://team33.com",
        description: "some description here:  Lorem ipsum dolor sit amet. Vel quasi neque est explicabo galisum in earum quam. Et maxime nostrum rem perspiciatis delectus qui voluptas velit ex recusandae nisi deserunt molestiae. Nam distinctio voluptas aut debitis modi aut quisquam sint!",
        ethnicity: "white"
    },
    {
        organizerName: "team 33 version 2",
        organizerEmail: "sps-team33@gmail.com",
        eventName: "team kickoff version 2",
        eventDate: "07/25/2022 10:00:00AM",
        ageGroup: "11th Grade",
        location: "Online",
        link: "http://team33-2.com",
        description: "some description here",
        ethnicity: "asian"
    }
];

var infomationdisplay = document.getElementById('event-details');

test.forEach((example, idx) => {
    // Create card element
    const card = document.createElement('div');
    card.classList = 'card-body';
  
    // Construct card content
    const info = `
      <div class="card">
        <div class="card-header" id="heading-${idx}">
        </div>
    
        <div id="collapse-${idx}" class="collapse show" aria-labelledby="heading-${idx}" data-parent="#accordion">
            <div class="card-body">
    
            <h5>${example.organizerName}</h5>
            <p>${example.organizerEmail}</p>
            <p>${example.eventName}</p>
            ...
            </div>
        </div>
      </div>
    `;

    const information = `
        <div class="card">
            <div class="card-body">
            <h5 class="card-title">${example.eventName}</h5>
            <p>
                <span>Email: ${example.organizerName}</span>
                <span style="color:#58585c; float: right;">Date: ${example.eventDate}</span>
            </p>
            <p>
                <span>${example.organizerEmail}</span>
                <span style="color:#58585c; float: right;">Location: ${example.location}</span>
            </p>
            <p>
                <span>Ethincity: ${example.ethnicity}</span>
                <span style="color:#58585c; float: right;">Target Age: ${example.ageGroup}</span>
            </p>
            <p class="card-text">Event details: ${example.description}</p>
            <a href=${example.link} class="card-link">Event link</a>
            </div>
        </div>
        <p></p>
    `;
    infomationdisplay.innerHTML += information;
  })
  
function loadEvent() {
    fetch('/form-responses').then(response => response.json()).then((events) => {
      const eventListElement = document.getElementById('event-details');
      events.forEach((event) => {
      })
    });
}
