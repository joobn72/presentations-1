<div class="section sectionWhite">
    <div class="container">
        <h1>${presentation.title}</h1>

        <div>
            <div id="leanpub" class="hidden-phone">
                <iframe width="160" height="400" src="http://leanpub.com/software-architecture-for-developers/embed" frameborder="0" allowtransparency="true"></iframe>
            </div>
            ${presentation.summary}
        </div>

        <p class="presentationMetaData">
            <c:choose>
                <c:when test="${presentation.author eq 'Simon Brown'}">
                    <a href="http://www.simonbrown.je" target="_blank">${presentation.author}</a>
                </c:when>
                <c:otherwise>
                    ${presentation.author}
                </c:otherwise>
            </c:choose>
            <c:if test="${not empty presentation.event}">
            |
                <fmt:formatDate value="${presentation.date}" pattern="dd MMMM yyyy" /> |
            ${presentation.event} |
            ${presentation.city}, ${presentation.country}
            <img src="${pageContext.request.contextPath}/static/img/flags/${presentation.country.flag}.png" alt="${presentation.country}" style="padding-bottom: 4px; vertical-align: middle;"/>
            </c:if>
        </p>

        <h4 style="margin-top: 32px;">Other formats</h4>
        <p>
            <c:if test="${not empty presentation.pdf}">
                <a href="${presentation.pdf}" target="_blank"><img
                        src="${pageContext.request.contextPath}/static/img/pdf.png" width="36px" alt="PDF" border="0"/></a>
            </c:if>
        </p>

    </div>
</div>
<div class="section sectionShaded">
    <div class="container">

        <div align="center">
            <div id="slideContainer">
                <img id="large-slide" class="slide img-polaroid" valign="bottom"
                     src="${pageContext.request.contextPath}/static/img/loading-slide.gif"/>
            </div>
        </div>

        <div align="center">
            <br/>
            <i class="icon-backward" id="previous"></i>
            &nbsp;
            <span class="badge"><span id="slideNumber">&nbsp;</span> of ${presentation.numberOfSlides}</span>
            &nbsp;
            <i class="icon-forward" id="next"></i>
        </div>

        <div id="lighttable">
        <c:forEach var="i" begin="1" end="${presentation.numberOfSlides}" varStatus="status">
            <c:if test="${status.index % 6 == 1}">
                <div class="row">
            </c:if>
                    <div class="span2 thumbnailContainer">
                        <img src="${presentation.base}thumbnails/slide.<fmt:formatNumber value="${i}" pattern="000" />.png" class="slideThumbnail img-polaroid" title="Slide ${i}"/>
                    </div>
            <c:if test="${status.index % 6 == 0}">
                </div>
            </c:if>

            <c:if test="${status.last and status.index % 6 ne 0}">
                <c:forEach begin="1" end="${6-(status.index % 6)}">
                    <div class="span2">&nbsp;</div>
                </c:forEach>
                </div>
            </c:if>
        </c:forEach>
        </div>
    </div>
</div>

<footer>
        <%@ include file="../fragments/shareme.jspf" %>
</footer>

<script type="text/javascript">
    $(document).ready(function() {
        numberOfSlides = ${presentation.numberOfSlides};

        loadSlide(${slideNumber});

        <c:if test="${slideNumber gt 1}">
            scrollToSlideContainer();
        </c:if>

        function loadSlide(slideNumber) {
            $('#large-slide').attr('slideNumber', slideNumber);
            $('#large-slide').attr('src', '${pageContext.request.contextPath}/static/img/loading-slide.gif');
            $('#large-slide').attr('src', formatFileName(slideNumber));
            $('#slideNumber').text(slideNumber);

            preloadSlide(slideNumber, -1);
            preloadSlide(slideNumber, 1);
        }

        function formatFileName(slideNumber) {
            return "${presentation.base}slides/slide." + pad(slideNumber, 3) + ".png";
        }

        function pad(number, length) {
            var str = '' + number;
            while (str.length < length) {
                str = '0' + str;
            }
            return str;
        }

        function preloadSlide(currentSlide, offset) {
            image = new Image();

            nextSlide = currentSlide + offset;
            if (nextSlide > 0 && nextSlide <= numberOfSlides) {
                image.src = formatFileName(nextSlide);
            }
        }

        function scrollToSlideContainer() {
            value = $('#slideContainer').offset().top;
            $('body,html').animate({
                scrollTop: value - 100
            }, '400');
        }

        $('.slideThumbnail').click(
                function() {
                    array = $(this).attr('src').split('/');
                    fileName = array[array.length - 1];
                    slide = parseInt(fileName.split('.')[1], 10);
                    loadSlide(slide);
                    scrollToSlideContainer();
                });

        function next() {
            currentSlide = parseInt($('#large-slide').attr('slideNumber'));
            if (currentSlide < numberOfSlides) {
                currentSlide = currentSlide + 1;
                loadSlide(currentSlide);
            }
        }

        function previous() {
            currentSlide = parseInt($('#large-slide').attr('slideNumber'));
            if (currentSlide > 1) {
                currentSlide = currentSlide - 1;
                loadSlide(currentSlide);
            }
        }

        $(document).keydown(function(e) {
            if (e.which == 37) {
                previous();
                scrollToSlideContainer();
            }
        });

        $(document).keydown(function(e) {
            if (e.which == 39) {
                next();
                scrollToSlideContainer();
            }
        });

        $('#next').click(function() {
                next();
            });

        $('#previous').click(
                function() {
                    previous();
                });

    });
</script>