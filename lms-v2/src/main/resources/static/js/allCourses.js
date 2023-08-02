 /*// JavaScript code in your courses.html or separate JS file
document.addEventListener("DOMContentLoaded", () => {
  const courseContainer = document.getElementById("courseContainer");

  // Fetch the course data from the server
  fetch("/courses/all")
    .then((response) => response.json())
    .then((data) => {
      // Loop through the data and create course items
      data.forEach((course) => {
        const courseItem = document.createElement("div");
        courseItem.className = "col-lg-4 col-md-6 wow fadeInUp";
        courseItem.setAttribute("data-wow-delay", "0.1s");

        courseItem.innerHTML = `
          <div class="course-item bg-light">
            <a href="/courses/${course.idCourse}">
            <img class="img-fluid" src="/img/course-1.jpg" alt="">
            <div class="text-center p-4 pb-0">
                <h3 class="mb-0">$149.00</h3>
                <div class="mb-3">
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small>(123)</small>
                </div>
                <h5 class="mb-4">${course.title}</h5>
            </div>
            <div class="d-flex border-top">
                <small class="flex-fill text-center border-end py-2"><i class="fa fa-user-tie text-primary me-2"></i>${course.instructor}</small>
                <small class="flex-fill text-center border-end py-2"><i class="fa fa-clock text-primary me-2"></i>${course.duration} Hrs</small>
                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>${course.students} Students</small>
            </div>
            </a>
          </div>
        `;

        courseContainer.appendChild(courseItem);
      });
    })
    .catch((error) => {
      console.error("Error fetching course data:", error);
    });
    
    

});

*/

// Function to create a course item
  function createCourseItem(course) {
    const courseItem = document.createElement("div");
    courseItem.className = "col-lg-4 col-md-6 wow fadeInUp";
    courseItem.setAttribute("data-wow-delay", "0.1s");

    courseItem.innerHTML = `
      <div class="course-item bg-light">
        <a href="/coursedetail.html?id=${course.idCourse}">
          <img class="img-fluid" src="/img/course-1.jpg" alt="">
            <div class="text-center p-4 pb-0">
                <h3 class="mb-0">$149.00</h3>
                <div class="mb-3">
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small class="fa fa-star text-primary"></small>
                    <small>(123)</small>
                </div>
                <h5 class="mb-4">${course.title}</h5>
            </div>
            <div class="d-flex border-top">
                <small class="flex-fill text-center border-end py-2"><i class="fa fa-user-tie text-primary me-2"></i>${course.instructor}</small>
                <small class="flex-fill text-center border-end py-2"><i class="fa fa-clock text-primary me-2"></i>${course.duration} Hrs</small>
                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>${course.students} Students</small>
            </div>
        </a>
      </div>
    `;

    return courseItem;
  }

  // Fetch the course data from the server
  fetch("/courses/all")
    .then((response) => response.json())
    .then((data) => {
      // Create and append course items to the container
      const courseContainer = document.getElementById("courseContainer");
      data.forEach((course) => {
        const courseItem = createCourseItem(course);
        courseContainer.appendChild(courseItem);
      });
    })
    .catch((error) => {
      console.error("Error fetching course data:", error);
    });

