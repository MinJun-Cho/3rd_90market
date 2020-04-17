<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/content/header.jsp" %>

    <!--슬라이더창 및 탑 버튼-->
    <section>
        <div class="div_container">
            <ul class="slider_container simple-list" id="slider">
                <li class="slide">조민준</li>
                <li class="slide">주태종</li>
                <li class="slide">정지수</li>
            </ul>

            <a href="#" id="prev"></a>
            <a href="#" id="next"></a>
        </div>
    </section>
    <!--//슬라이더창 및 탑 버튼-->

    <!--카테고리별 인기상품 -->
    <section class="main">
        <div class="section_category">
            <div>
                <h2>카테고리 인기 상품</h2>
            </div>
            <div class="category_button">
                <div>
                    <a href="#fashion"><button class="ct1">패션잡화</button></a>
                    <a href="#women"><button class="ct1">여성의류</button></a>
                    <a href="#men"><button class="ct1">남성의류</button></a>
                    <a href="#Appliances"><button class="ct1">디지털/가전</button></a>
                    <a href="#books"><button class="ct1">도서/티켓/취미/애완</button></a>
                    <a href="#young"><button class="ct1">유아동/출산</button></a>
                    <a href="#life"><button class="ct1">생활/문구/가구/식품</button></a>
                    <a href="#beauti"><button class="ct1">뷰티/미용</button></a>
                    <a href="#sport"><button class="ct2">스포츠/레저</button></a>
                    <a href="#car"><button class="ct2">차량/오토바이</button></a>
                    <a href="#etc"><button class="ct2">기타</button></a>
                    <button id="clickbtn"><img
                            src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAASCAYAAABvqT8MAAAAAXNSR0IArs4c6QAAAfZJREFUKBVtkstq21AQhi3pqCpWUllWkippCjY2WcWbLPoahS76Bl2XkscIhe7zAllkVbrMY8S0pGCwsWIS2U6ELFRfJPUbg4ubeGA0M2f+fy7nSKvX679KpVKEXmqaFsRx/D0MwwnxRtE5DYuieARcxndM06zWarUKvuSeieG6bh/wTzIf0BMIb3VdP/I874bu88FgkK+zlGEYAYA/s9lMxpCqVTpmFPEnk4lJHKIZuiRqOC9Qs9Fo7C8Wi10KfCKuQFpAGmG/lcvlsN1uPwpJ8Zmhc6XUXZZlAhoS63me70onChxMp1ODs6ngpMNKZBzd930XcoVd3hPvUeAEYsLZV+xImCspcHLmTknObds+JDYBvYNk072Nr9Y7rIhitWazuc1FHEI+B+hzNkazjXctBHQpgGmgSXeRQpZ+KobjOK8AfmThN9iXAIZcwhnE0TpBuhk8lryDy8yvAbjokDjmEm4hDVet9Var5SRJskPyM7rDY1rYCOI5e9x3Op2AgnPFclYURWaapvtU2OOwim4DHlNdFh1AlrdJ0UKROGZmj0pfSGxxeI3+Jr4gHvd6veXtCBgtKaoeYGVWGyv3PsKXV7/rdrvy28t/9E9k6VNACdV+4N/zG1xZlhX3+/2Y+L8/VVhC8Kgoo8WQHvgBH4IgSCS5Sf4Cbfj85T5s+hEAAAAASUVORK5CYII="
                            alt="화살표 아이콘" width="6" height="9">
                    </button>
                </div>
            </div>
        </div>

        <!--//카테고리별 인기상품 -->

        <!--카테고리별 나누기-->
        <!--패션잡화-->
        <section>
            <div class="fashion" id="fashion">
                <div class="name">패션잡화
                    <a href="/category/fashion">전체보기</a>
                </div>
                <div class="box_container">
                	<c:forEach var="fashion" items="${fashion}">
                    <a href="/product/read?bno=${fashion.bno}">
                        <div class="box">
                            <div>
                                <img src="${fashion.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${fashion.title}</div>
                                <div class="price">${fashion.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            
            <!--//패션잡화-->
            <!--여성의류-->
            <div class="fashion" id="women">
                <div class="name">여성의류
                    <a href="/category/women">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="women" items="${women}">
                    <a href="/product/read?bno=${women.bno}">
                        <div class="box">
                            <div>
                                <img src="${women.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${women.title}</div>
                                <div class="price">${women.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//여성의류-->
            <!--남성의류-->
            <div class="fashion" id="men">
                <div class="name">남성의류
                    <a href="/category/men">전체보기</a>
                </div>
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
            </div>
            <!--//남성의류-->
            <!--디지털/가전-->
            <div class="fashion" id="Appliances">
                <div class="name">디지털/가전
                    <a href="/category/appliances">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="appliances" items="${appliances}">
                    <a href="/product/read?bno=${appliances.bno}">
                        <div class="box">
                            <div>
                                <img src="${appliances.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${appliances.title}</div>
                                <div class="price">${appliances.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//디지털/가전-->
            <!--도서/티켓/취미/애완-->
            <div class="fashion" id="books">
                <div class="name">도서/티켓/취미/애완
                    <a href="/category/books">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="books" items="${books}">
                    <a href="/product/read?bno=${books.bno}">
                        <div class="box">
                            <div>
                                <img src="${books.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${books.title}</div>
                                <div class="price">${books.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//도서/티켓/취미/애완-->
            <!--유아동/출산-->
            <div class="fashion" id="young">
                <div class="name">유아동/출산
                    <a href="/category/young">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="young" items="${young}">
                    <a href="/product/read?bno=${young.bno}">
                        <div class="box">
                            <div>
                                <img src="${young.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${young.title}</div>
                                <div class="price">${young.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//유아동/출산-->
            <!--생활/문구/가구/식품-->
            <div class="fashion" id="life">
                <div class="name">생활/문구/가구/식품
                    <a href="/category/life">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="life" items="${life}">
                    <a href="/product/read?bno=${life.bno}">
                        <div class="box">
                            <div>
                                <img src="${life.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${life.title}</div>
                                <div class="price">${life.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//생활/문구/가구/식품-->
            <!--뷰티/미용-->
            <div class="fashion" id="beauti">
                <div class="name">뷰티/미용
                    <a href="/category/beauti">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="beauti" items="${beauti}">
                    <a href="/product/read?bno=${beauti.bno}">
                        <div class="box">
                            <div>
                                <img src="${beauti.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${beauti.title}</div>
                                <div class="price">${beauti.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//뷰티/미용-->
            <!--스포츠/레저-->
            <div class="fashion" id="sport">
                <div class="name">스포츠/레저
                    <a href="/category/sport">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="sport" items="${sport}">
                    <a href="/product/read?bno=${sport.bno}">
                        <div class="box">
                            <div>
                                <img src="${sport.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${sport.title}</div>
                                <div class="price">${sport.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//스포츠/레저-->
            <!--차량/오토바이-->
            <div class="fashion" id="car">
                <div class="name">차량/오토바이
                    <a href="/category/car">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="car" items="${car}">
                    <a href="/product/read?bno=${car.bno}">
                        <div class="box">
                            <div>
                                <img src="${car.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${car.title}</div>
                                <div class="price">${car.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//차량/오토바이-->
            <!--기타-->
            <div class="fashion" id="etc">
                <div class="name">기타
                    <a href="/category/etc">전체보기</a>
                </div>
                <div class="box_container">
                    <c:forEach var="etc" items="${etc}">
                    <a href="/product/read?bno=${etc.bno}">
                        <div class="box">
                            <div>
                                <img src="${etc.thumbnail}" alt="제품사진 이미지">
                            </div>
                            <div class="box2">
                                <div class="title">${etc.title}</div>
                                <div class="price">${etc.price}<SPAN>원</SPAN></div>
                            </div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
            <!--//기타-->
        </section>
    </section>
    <!--//카테고리별 나누기-->

<%@ include file="/WEB-INF/views/content/footer.jsp" %>