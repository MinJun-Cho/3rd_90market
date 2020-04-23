<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/content/header.jsp" %>

    <section>
        <div class="sell">
            <div class="sell_info">
                <h2>기본정보</h2>
            </div>
            <form action="/product/postCreate" method="post" enctype="multipart/form-data">
            <div class="sell_image">
                <div>
                    <div class="sell_image_name">상품이미지</div>
                    <div class="sell_image_box">
                        <div class="sell_image_box1">
                            <div><i class="fas fa-camera">

                                </i>이미지등록하기
                                <input type="file" name="file" accept="image/jpg, image/jpeg, image/png" multiple="multiple" />
                            </div>
                            <div class='sell_image_box2'>

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
                <div class='sell_title_container_name'>제목</div>
                <div class='sell_title_container_input'>
                    <input type="text" placeholder="상품 제목을 입력해주세요." name="title">
                </div>
            </div>
            <div class="sell_category_container">
                <div class="sell_category_container_title">
                    <div>카테고리</div>
                </div>
                <div class='sell_category_container_ul'>
                     <ul>
                        <li><input  type="radio" id="id1" value="fashion" name="category"><label for='id1'>패션잡화</label></li>
                        <li><input  type="radio" id="id2" value="women" name=category><label for='id2'>여성의류</label></li>
                        <li><input  type="radio" id="id3" value="men" name=category><label for='id3'>남성의류</label></li>
                        <li><input  type="radio" id="id4" value="appliances" name=category><label for='id4'>디지털가전</label></li>
                        <li><input  type="radio" id="id5" value="books" name=category><label for='id5'>도서/티켓/취미/애완</label></li>
                        <li><input  type="radio" id="id6" value="young" name=category><label for='id6'>유아동/출산</label></li>
                        <li><input  type="radio" id="id7" value="life" name=category><label for='id7'>생활/문구/가구/식품</label></li>
                        <li><input  type="radio" id="id8" value="beauti" name=category><label for='id8'>뷰티/미용</label></li>
                        <li><input  type="radio" id="id9" value="sport" name=category><label for='id9'>스포츠/레저</label></li>
                        <li><input  type="radio" id="id10" value="car" name=category><label for='id10'>차량/오토바이</label></li>
                        <li><input  type="radio" id="id11" value="etc" name=category><label for='id11'>기타</label></li>
                    </ul>
                </div>
                <div class="cate1">현재 선택한 카테고리:<span></span></div>
            </div>
            <div class='sell_price'>
                <div class='sell_price_name'>
                    가격
                </div>
                <div class='sell_price_container'>
                    <div>
                        <input type="text" placeholder="숫자만 입력해주세요." name="price"><span>원</span>
                    </div>
                </div>
            </div>

            <div class="sell_Explanation">
                <div class='sell_Explanation_name'>
                    설명
                </div>
                <div class='sell_Explanation_container'>
                    <textarea placeholder="상품설명을 입력해 주세요." name="content"></textarea>
                </div>
            </div>
            <div class='sell_Quantity'>
                <div class='sell_Quantity_name'>
                    수량
                </div>
                <div class='sell_Quantity_container'>
                    <div>
                        <input type="text" placeholder="1" name="amount"><span>개</span>
                    </div>
                </div>
            </div>
            <div class='sell_btn'>
                <div>
                    <button type="submit">등록하기</button>
                </div>
            </div>
            </form>
        </div>
    </section>
    
    <script src="/resources/js/menu.js"></script>
    <script src="/resources/js/imgupload.js?ver=0.4"></script>

<%@ include file="/WEB-INF/views/content/footer.jsp" %>