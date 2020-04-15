var targetLink = document.querySelectorAll('.myshop_container_bottom button')

    
    targetLink[0].addEventListener('click', function(){
        var tabTarget = '#product';
        var tabTarget2 = '#product2'
        document.querySelector(tabTarget).style.display = 'block';
        document.querySelector(tabTarget2).style.display = 'block';
        var tabTarget3 = '#product3';
        var tabTarget4 = '#product4'
        document.querySelector(tabTarget3).style.display = 'none';
        document.querySelector(tabTarget4).style.display = 'none';
    })

    targetLink[1].addEventListener('click', function(){
        var tabTarget3 = '#product3';
        var tabTarget4 = '#product4';
        document.querySelector(tabTarget3).style.display = 'block';
        document.querySelector(tabTarget4).style.display = 'block';
        var tabTarget = '#product';
        var tabTarget2 = '#product2';
        document.querySelector(tabTarget).style.display = 'none';
        document.querySelector(tabTarget2).style.display = 'none';
    })



