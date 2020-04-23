<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/content/header.jsp" %>

    <section>
        <div>
            <div class="info_container">
                <div class="info_container_img">
                    <div class="info_container_img1">
                        <div class="info_container_img2">
                        	<c:forEach var="image" items="${images}">
                            <li class="slide1"><img src="<c:out value="${image}" />" /></li>
                            </c:forEach>
                        </div>
                        <a id="prevBtn"></a>
                        <a id="nextBtn"></a>
                    </div>
                </div>
                <div class="info_container_info">
                    <div class="info_container_info1">
                        <div class="info_container_info2">
                            <div class="info_container_info2_name">
                                <div class='info_container_info2_name2'>${product.title}</div>
                                <div class='info_container_info2_name_price'>
                                    <div class="comma">${product.price}원</div>
                                </div>
                            </div>
                            <div class="info_container_info2_info">
                                <div class='info_container_info2_info1'>상품상태</div>
                                <span>중고상품</span>
                                <div class='info_container_info2_info1'>교환여부</div>
                                <span>교환가능</span>
                                <div class='info_container_info2_info1'>배송비</div>
                                <span>배송비 별도</span>
                                <div class='info_container_info2_info1'>판매자></div>
                                <span>${product.seller}</span>
                                <div class='info_container_info2_info2'>
                                    <button id='info_btn'>연락하기</button>
                                    <button id='info_btn2'>바로구매</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="info_container2">
                <button>상품정보</button>
                <div>
                    <div id="p">${product.content}</div>
                </div>
            </div>
       	</div>
    </section>
    
    <script src="/resources/js/product_slide.js?ver=0.1"></script>

<%@ include file="/WEB-INF/views/content/footer.jsp" %>