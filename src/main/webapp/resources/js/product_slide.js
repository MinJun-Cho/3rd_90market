let sliderWrapper = document.querySelector(".info_container_img1");
let sliderContainer = document.querySelector(".info_container_img2");
let slides = document.querySelectorAll(".info_container_img2 .slide1");
let slideCount = slides.length;
let currentIndex = 0;
let topHeight = 0;
let navPrev = document.querySelector('#prevBtn');
let navNext = document.querySelector('#nextBtn');



for (var i = 0; i < slideCount; i++) {
    slides[i].style.left = i*100 +'%'
}

function goToSlide(idx){
    sliderContainer.style.left = idx * -100 + '%';
    sliderContainer.classList.add('animated')
    currentIndex = idx;
}

function updateNav(){
    if(currentIndex == 0){
        navPrev.classList.add('disabled');
        navPrev.style.display ='none'
    }else{
        navPrev.classList.remove('disabled');
        
    }
    if(currentIndex == slideCount - 1){
        navNext.classList.add('disabled');
    }else{
        navNext.classList.remove('disabled');
    }
}


navPrev.addEventListener('click', function(event){
    event.preventDefault();
    
    if(currentIndex > 0){
        goToSlide(currentIndex - 1);
    }else{
        goToSlide(slideCount - 1);
    }
})

navNext.addEventListener('click', function(event){
    event.preventDefault();
    
    if(currentIndex < slideCount - 1 ){
        goToSlide(currentIndex + 1);
    }else{
        goToSlide(0);
    }
})

var comma1 = document.querySelector(".info_container_info2_name_price div");

function numberWithCommas(x){
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
    
comma1.innerText = numberWithCommas(comma1.innerText)