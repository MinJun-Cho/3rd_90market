<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/content/header.jsp" %>

    <section class="main">
        <div class="fashion">
            <div class="name">남성의류</div>
            <div class="box_container">
                <c:forEach var="men" items="${men}">
                <a href="/product/read?bno=${men.bno}">
                <div class="box">
                    <div>
                        <img src="${men.thumbnail}" alt="제품사진 이미지">
                    </div>
                    <div class="box2">
                        <div class="title">${men.title}</div>
                        <div class="price">${men.price}<SPAN>원</SPAN></div>
                    </div>
                </div>
                </a>
                </c:forEach>
            </div>
            <div class="page">
                <ul class="pargination modal">
                    <li><a href="#" class = "num">1</a></li>
                    <li><a href="#" class = "num">2</a></li>
                    <li><a href="#" class = "num">3</a></li>
                    <li><a href="#" class = "num">4</a></li>
                    <li><a href="#" class = "num">5</a></li>
                    <li><a href="#" class = "num">6</a></li>
                    <li><a href="#" class = "num">7</a></li>
                    <li><a href="#" class = "num">8</a></li>
                    <li><a href="#" class = "num">9</a></li>
                    <li><a href="#" class = "num">10</a></li>
                    <li><a href="#" class = "num">>></a></li>
                </ul>
            </div>
        </div>
    </section>

<%@ include file="/WEB-INF/views/content/footer.jsp" %>