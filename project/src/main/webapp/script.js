function addMessage() {
  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = "Stop clicking buttons and get to work!";
}
  
function loadEvent() {
    fetch('/form-responses').then(response => response.json()).then((events) => {
      var infomationdisplay = document.getElementById('event-details');
      events.forEach((event) => {
        const card = document.createElement('div');
        card.classList = 'card-body';
    
        const information = `
            <div class="card">
                <div class="card-body">
                <h5 class="card-title">${event.eventName}</h5>
                <p>
                    <span>Email: ${event.organizerName}</span>
                    <span style="color:#58585c; float: right;">Date: ${event.eventDate}</span>
                </p>
                <p>
                    <span>${event.organizerEmail}</span>
                    <span style="color:#58585c; float: right;">Location: ${event.location}</span>
                </p>
                <p>
                    <span>Ethincity: ${event.ethnicity}</span>
                    <span style="color:#58585c; float: right;">Target Age: ${event.ageGroup}</span>
                </p>
                <p class="card-text">Event details: ${event.description}</p>
                <a href=${event.link} class="card-link">Event link</a>
                </div>
            </div>
            <p></p>
        `;
        infomationdisplay.innerHTML += information;
      })
    });
}
