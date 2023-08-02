/*// Use Fetch API to make the AJAX request to the Spring controller
        fetch('/courses/${id}') // Replace this URL with the endpoint of your Spring controller that returns the course data
            .then(response => response.json())
            .then(data => {
                // Call a function to display the course data
                displayCourses(data);
            })
            .catch(error => console.error('Error fetching course data:', error));

        // Function to display the course data
        function displayCourses(courses) {
         console.log(courses);
        }*/
        

  /*document.addEventListener("DOMContentLoaded", () => {
    const courseContainer = document.getElementById("courseContainer");
	
    
     // Fetch the course data from the server
    fetch(`/courses/${id}`)
      .then((response) => response.json())
      .then((data) => {
        // Call a function to display the course data
        displayCourse(data);
      })
      .catch((error) => {
        console.error("Error fetching course data:", error);
      });

    // Function to display the course data
    function displayCourse(course) {
      // Create the course item dynamically based on the fetched data
      const courseItem = document.createElement("div");
      courseItem.className = "col-lg-4 col-md-6 wow fadeInUp";
      courseItem.setAttribute("data-wow-delay", "0.1s");

      courseItem.innerHTML = `
        <div class="course-item bg-light">
          <!-- Rest of the HTML content for the course item -->
          <!-- You can use the properties of the 'course' object to fill in the data dynamically -->
          <img class="img-fluid" src="${course.image}" alt="">
          <div class="text-center p-4 pb-0">
            <h3 class="mb-0">$${course.price}</h3>
            <!-- Rest of the course data -->
          </div>
          <!-- Rest of the course data -->
        </div>
      `;

      courseContainer.appendChild(courseItem);
    }
  });*/
/*  
  // Get the course ID from the URL
        const courseId = getCourseIdFromUrl();

        // Use Fetch API to make the AJAX request to the Spring controller
        fetch(`/courses/${courseId}`)
            .then(response => response.json())
            .then(data => {
                // Call a function to display the course data
                displayCourse(data);
            })
            .catch(error => console.error('Error fetching course data:', error));

        // Function to extract the course ID from the URL
        function getCourseIdFromUrl() {
            const path = window.location.pathname;
            const parts = path.split('/');
            return parts[parts.length - 1];
        }

        // Function to display the course data
        function displayCourse(course) {
            const courseContainer = document.querySelector('#courseContainer');
            const courseElement = document.createElement('div');
            courseElement.innerHTML = `
                <h3>${course.name}</h3>
                <p>Instructor: ${course.instructor}</p>
                <!-- Add more course details as needed -->
            `;
            courseContainer.appendChild(courseElement);
        }
    */
   
   // Function to retrieve the course ID from the URL query parameter
    function getCourseIdFromUrl() {
      const queryParams = new URLSearchParams(window.location.search);
      return queryParams.get("id");
    }

    // Fetch the course data using the course ID from the URL
    const courseId = getCourseIdFromUrl();
    if (courseId) {
      const url = `/courses/${courseId}`;
      fetch(url)
        .then((response) => response.json())
        .then((course) => {
          // Call a function to populate the course detail content dynamically
          populateCourseDetail(course);
        })
        .catch((error) => {
          console.error("Error fetching course data:", error);
        });
    }

    // Function to populate the course detail content dynamically
    function populateCourseDetail(course) {
      // Get the elements where you want to display the course data and update their content
      // For example:
      const courseTitleElement = document.getElementById("title");
      const courseInstructorElement = document.getElementById("courseInstructor");

      // Set the content of the elements with the course data
      courseTitleElement.textContent = course.title;
      courseInstructorElement.textContent ='Instructor : '+ course.instructor;

      // Add more code to populate other course details as needed
    }
