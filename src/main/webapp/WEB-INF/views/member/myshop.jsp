<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/content/header.jsp" %>

     <section>
        <div class="myshop">
            <div class="myshop_container">
                <div class="myshop_container_top">
                    <div class="myshop_container_top_box">
                        <div>
                            <button type="button">내상점관리</button>
                        </div>
                    </div>
                    <div class="myshop_container_top_contents">
                        <div class="myshop_container_top_contents_name">상점 1호
                            <button type="button" class="btn">상품명 수정</button></div>
                        <div>
                            <button type="button" class="btn" id="btn">소개글 수정</button>
                        </div>
                    </div>
                </div>
                <div class="myshop_container_bottom">
                    <div class="myshop_container_bottom_box">
                        <button>상품<span>0</span></button>
                        <button>찜<span>0</span></button>
                    </div>
                    <div id="product" class="active">
                        <div>상품<span>0</span></div>
                        <div id="product2" class="active">
                            <div>등록된 상품이 없습니다.</div>
                        </div>
                    </div>
                    <div>

                        <div id="product3">
                            <div>찜<span>0</span></div>
                        </div>
                        <div id="product4">
                            <div>찜한 상품이 없습니다.</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
<%@ include file="/WEB-INF/views/content/footer.jsp" %>