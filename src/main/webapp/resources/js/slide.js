let sliderWrapper = document.querySelector(".div_container");
let sliderContainer = document.querySelector(".slider_container");
let slides = document.querySelectorAll(".slide");
let slideCount = slides.length;
let currentIndex = 0;
let topHeight = 0;
let navPrev = document.querySelector('#prev');
let navNext = document.querySelector('#next');

function calculateTallestSlide() {
    
    for (var i = 0; i < slideCount; i++) {

        if (slides[i].offsetHeight > topHeight) {
            topHeight = slides[i].offsetHeight;
        }
    }

    sliderWrapper.style.height = topHeight + 'px';
    sliderContainer.style.height = topHeight + 'px';
}

calculateTallestSlide();

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

setInterval(function(){
    
    var nextInx = (currentIndex + 1) % slideCount ;
    
    goToSlide(nextInx);


},3000);

var ct1 = document.getElementsByClassName('ct1');
var ct2 = document.getElementsByClassName('ct2');
var clickbtn = document.getElementById('clickbtn');
var count = 0;



clickbtn.addEventListener('click',function(){
    if(count < 1){
        ct1[0].style.display = 'none';
        ct1[1].style.display = 'none';
        ct1[2].style.display = 'none';
        ct1[3].style.display = 'none';
        ct1[4].style.display = 'none';
        ct1[5].style.display = 'none';
        ct1[6].style.display = 'none';
        ct1[7].style.display = 'none';
        ct2[0].style.display = 'block';
        ct2[1].style.display = 'block';
        ct2[2].style.display = 'block';
        count = 2;
    }else if (count > 1){
        ct1[0].style.display = 'block';
        ct1[1].style.display = 'block';
        ct1[2].style.display = 'block';
        ct1[3].style.display = 'block';
        ct1[4].style.display = 'block';
        ct1[5].style.display = 'block';
        ct1[6].style.display = 'block';
        ct1[7].style.display = 'block';
        ct2[0].style.display = 'none';
        ct2[1].style.display = 'none';
        ct2[2].style.display = 'none';
        count = 0;
    }
});

var menu = document.querySelector('.menu span i');
var menu2 = document.querySelector('.menu div');

console.log(menu2)

menu.addEventListener('mouseenter',function(){
    menu.style.diplay = "inline-block";

})
















