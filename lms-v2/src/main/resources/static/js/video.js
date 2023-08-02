//let currentSlide = 0;
const slides = document.querySelectorAll('.slide');
//const nextButton = document.querySelector('.next-btn');
//const prevButton = document.querySelector('.prev-btn');

function showSlide(slideIndex) {
    slides.forEach((slide, index) => {
        if (index === slideIndex) {
            slide.style.display = 'block';
        } else {
            slide.style.display = 'none';
        }
    });
    currentSlide = slideIndex;

    // Enable/disable the Next button based on video completion
    const videoPlayer = slides[currentSlide].querySelector('video');
    nextButton.disabled = !videoPlayer.ended;
}

function changeSlide(direction) {
    currentSlide += direction;
    if (currentSlide < 0) {
        currentSlide = slides.length - 1;
    } else if (currentSlide >= slides.length) {
        currentSlide = 0;
    }
    showSlide(currentSlide);
}

document.addEventListener('DOMContentLoaded', function() {
    // Show the first slide initially
    showSlide(currentSlide);

    // Get all checkboxes
    const checkboxes = document.querySelectorAll('.section-item');

    // Add change event listener to each checkbox
    checkboxes.forEach((checkbox) => {
        checkbox.addEventListener('change', () => {
            const sectionId = checkbox.dataset.sectionId;
            const completed = checkbox.checked;

            // Save the completion status to local storage
            saveCompletionStatus(sectionId, completed);
        });
    });

   

    // Get the video elements
    const videos = document.querySelectorAll('video');

    // Add event listener to each video to detect when it ends
    videos.forEach((video) => {
        video.addEventListener('ended', () => {
            // Find the corresponding checkbox and mark the section as completed
            const sectionId = video.dataset.sectionId;
            const sectionItem = document.querySelector(`li.list-group-item.section-item[data-section-id="${sectionId}"]`);
            sectionItem.classList.add('completed');

            // Save the completion status to local storage
            saveCompletionStatus(sectionId, true);

             // Enable the Next button when the video ends
             nextButton.disabled = false;
        });
    });
});

function loadCourseData() {
    loadCompletionStatus();
   
}

function loadCompletionStatus() {
    const sections = localStorage.getItem('completedSections');
    if (sections) {
        const completedSections = JSON.parse(sections);
        const checkboxes = document.querySelectorAll('.section-item');

        checkboxes.forEach((checkbox) => {
            const sectionId = checkbox.dataset.sectionId;
            checkbox.checked = completedSections.includes(sectionId);

            // Disable the checkbox if it's completed
            if (completedSections.includes(sectionId)) {
                checkbox.disabled = true;
            }
        });
    }
}


function saveCompletionStatus(sectionId, completed) {
    const sections = localStorage.getItem('completedSections');
    let completedSections = sections ? JSON.parse(sections) : [];

    if (completed) {
        if (!completedSections.includes(sectionId)) {
            completedSections.push(sectionId);
        }
    } else {
        completedSections = completedSections.filter(id => id !== sectionId);
    }

    localStorage.setItem('completedSections', JSON.stringify(completedSections));
}

function saveExpansionStatus(chapterId, expanded) {
    const expandedChapters = localStorage.getItem('expandedChapters');
    let expandedChaptersArray = expandedChapters ? JSON.parse(expandedChapters) : [];

    if (expanded) {
        if (!expandedChaptersArray.includes(chapterId)) {
            expandedChaptersArray.push(chapterId);
        }
    } else {
        expandedChaptersArray = expandedChaptersArray.filter(id => id !== chapterId);
    }

    localStorage.setItem('expandedChapters', JSON.stringify(expandedChaptersArray));
}
