document.getElementById('loginForm').addEventListener('submit', function (e) {
    e.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    fetch('http://localhost:8081/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Login failed.');
        }
        window.location.href = "/home"
        return response.text();
    })
    .then(data => {
        document.getElementById('loginMessage').innerText = data;
    })
    .catch(error => {
        document.getElementById('loginMessage').innerText = error.message;
    });
    
    document.getElementById('username').value="";
	document.getElementById('password').value="";
});
