    // Function to check if the user is authenticated
    function checkAuthenticationStatus() {
        fetch("/checkAuthentication")
            .then(response => response.json())
            .then(data => {
                if (data.authenticated) {
                    // User is authenticated, show username and logout button, hide login button
                    document.getElementById("username").textContent = data.username;
                    document.getElementById("username").style.display = "inline";
                    document.getElementById("logoutBtn").style.display = "inline";
                    document.getElementById("loginBtn").style.display = "none";
                } else {
                    // User is not authenticated, show login button, hide username and logout button
                    document.getElementById("loginBtn").style.display = "inline";
                    document.getElementById("username").style.display = "none";
                    document.getElementById("logoutBtn").style.display = "none";
                }
            })
            .catch(error => console.error('Error:', error));
    }

    // Function to handle the logout
    function logout() {
        fetch("/logout")
            .then(response => {
                if (response.ok) {
                    // After successful logout, reload the page to reflect the changes
                    window.location.reload();
                } else {
                    // Handle error or logout failure here
                    console.error('Logout failed:', response.statusText);
                }
            })
            .catch(error => console.error('Error:', error));
    }
    
    // Add an event listener for the enroll button click
    document.getElementById("enrollmentBtn").addEventListener("click", function() {
        
        fetch("/checkAuthentication")
            .then(response => response.json())
            .then(data => {
                if (data.authenticated) {
                    // User is authenticated
                    alert("it's ok");
                    
                } else {
                    // User is not authenticated
                     window.location.href = "/login.html";
                }
        
        
        
    });
    });

    // Add an event listener for the login button click
    document.getElementById("loginBtn").addEventListener("click", function() {
        // Redirect the user to the login page when the login button is clicked
        window.location.href = "/login.html";
    });

    // Add an event listener for the logout button click
    document.getElementById("logoutBtn").addEventListener("click", logout);

    // Call the function when the page loads
    checkAuthenticationStatus();

