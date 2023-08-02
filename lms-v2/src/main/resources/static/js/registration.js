document.getElementById('registrationForm').addEventListener('submit', function (e) {
    e.preventDefault();
    
    const username = document.getElementById('regusername').value;
    const email = document.getElementById('regemail').value;
    const password = document.getElementById('regpassword').value;
    
    fetch('http://localhost:8081/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, email, password })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Registration failed.');
        }
        return response.text();
    })
    .then(data => {
        document.getElementById('RegistrationMessage').innerText = data;
    })
    .catch(error => {
        document.getElementById('RegistrationMessage').innerText = error.message;
    });
    
    document.getElementById('regusername').value="";
    document.getElementById('regemail').value="";
	document.getElementById('regpassword').value="";
});
