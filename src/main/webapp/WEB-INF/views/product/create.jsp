<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/content/header.jsp" %>

    <section>
        <div class="sell">
            <div class="sell_info">
                <h2>기본정보</h2>
            </div>
            <div class="sell_image">
                <div>
                    <div class="sell_image_name">상품이미지</div>
                    <div class="sell_image_box">
                        <div class="sell_image_box1">
                            <div><i class="fas fa-camera">

                                </i>이미지등록하기
                                <input type="file" accept="image/jpg, image/jpeg, image/png" multiple="" />
                            </div>
                            <div class="sell_image_box2">

                                <button type="button" id="delete"></button>
                            </div>
                        </div>
                        <ul>
                            <li id="sell_first"> * 상품 이미지는 640x640에 최적화 되어 있습니다.</li>
                            <li>- 이미지는 상품등록 시 정사각형으로 짤려서 등록됩니다.</li>
                            <li>- 이미지를 클릭 할 경우 원본이미지를 확인할 수 있습니다.</li>
                            <li>- 이미지를 클릭 후 이동하여 등록순서를 변경할 수 있습니다.</li>
                            <li>- 큰 이미지일경우 이미지가 깨지는 경우가 발생할 수 있습니다.
                                (개당 이미지 최대 10M)</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="sell_title_container">
                <div class="sell_title_container_name">제목</div>
                <div class="sell_title_container_input">
                    <input type="text" placeholder="상품 제목을 입력해주세요." value="">
                </div>
            </div>
            <div class="sell_category_container">
                <div class="sell_category_container_title">
                    <div>카테고리</div>
                </div>
                <div class="sell_category_container_ul">
                    <ul>
                        <li><button type="button">패션잡화</button></li>
                        <li><button type="button">여성의류</button></li>
                        <li><button type="button">남성의류</button></li>
                        <li><button type="button">디지털가전</button></li>
                        <li><button type="button">도서/티켓/취미/애완</button></li>
                        <li><button type="button">유아동/출산</button></li>
                        <li><button type="button">생활/문구/가구/식품</button></li>
                        <li><button type="button">뷰티/미용</button></li>
                        <li><button type="button">스포츠/레저</button></li>
                        <li><button type="button">차량/오토바이</button></li>
                        <li><button type="button">기타</button></li>
                    </ul>
                </div>
            </div>
            <div class="sell_price">
                <div class="sell_price_name">
                    가격
                </div>
                <div class="sell_price_container">
                    <div>
                        <input type="text" placeholder="숫자만 입력해주세요." value=""><span>원</span>
                    </div>
                </div>
            </div>

            <div class="sell_Explanation">
                <div class="sell_Explanation_name">
                    설명
                </div>
                <div class="sell_Explanation_container">
                    <textarea placeholder="상품설명을 입력해 주세요."></textarea>
                </div>
            </div>
            <div class="sell_Quantity">
                <div class="sell_Quantity_name">
                    수량
                </div>
                <div class="sell_Quantity_container">
                    <div>
                        <input type="text" placeholder="1" value=""><span>개</span>
                    </div>
                </div>
            </div>
            <div class="sell_btn">
                <div>
                    <button>등록하기</button>
                </div>
            </div>
        </div>
    </section>

<%@ include file="/WEB-INF/views/content/footer.jsp" %>