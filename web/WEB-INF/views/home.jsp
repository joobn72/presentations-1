<div class="section sectionWhite">
    <div class="container">
        <h1>Presentations</h1>
        <p>
            We regularly speak about software development; at events ranging from large conferences through to small user groups and specialist events. The slides from most of the presentations can be downloaded as a PDF or viewed online. They cover a range of topics related to software architecture, technical leadership and the balance with agility.
        </p>

        <p>
        We've presented keynotes, sessions and workshops in these countries...
        </p>
        <c:forEach var="country" items="${countries}">
            <img src="${pageContext.request.contextPath}/static/img/flags/${country.flag}.png" alt="${country.name}" title="${country.name}" style="padding-bottom: 4px; vertical-align: middle;" />
        </c:forEach>
    </div>
</div>

<div class="section sectionShaded">
    <div class="container">
        <c:forEach var="presentation" items="${presentations}" varStatus="status">
            <c:if test="${status.index % 3 == 0}">
                <div class="row">
            </c:if>
                    <div class="span4">
                        <h4><a href="./${presentation.id}">${presentation.title}</a></h4>
                        <p>
                            ${presentation.truncatedSummary}
                        </p>
                        <p>
                            <a href="./${presentation.id}"><img src="${presentation.base}thumbnails/slide.001.png" class="slideThumbnail img-polaroid" border="0" alt="Thumbnail" /></a>
                        </p>
                        <p class="presentationMetaData">
                            ${presentation.author}, <fmt:formatDate value="${presentation.date}" pattern="dd MMMM yyyy" />
                            <br />
                            <img src="${pageContext.request.contextPath}/static/img/flags/${presentation.country.flag}.png" alt="${presentation.country}" style="padding-bottom: 4px; vertical-align: middle;" />
                            ${presentation.event}, ${presentation.country}
                        </p>
                    </div>
            <c:if test="${status.index % 3 == 2}">
                </div>
            </c:if>

            <c:if test="${status.last and status.index % 3 ne 2}">
                <c:forEach begin="1" end="${2-(status.index % 3)}">
                    <div class="span4">&nbsp;</div>
                </c:forEach>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>

<footer>
    <div id="shareme">
        <div class="row">
            <div class="span3">
                <a href="http://twitter.com/share" class="twitter-share-button" data-count="horizontal" data-url="http://www.codingthearchitecture.com/presentations/" data-via="simonbrown">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
            </div>
            <div class="span3">
                <script type="text/javascript" src="http://platform.linkedin.com/in.js"></script><script type="in/share" data-url="http://www.codingthearchitecture.com/presentations/" data-counter="right"></script>
            </div>
            <div class="span3">
                <iframe src="http://www.facebook.com/plugins/like.php?href=http://www.codingthearchitecture.com/presentations/&amp;layout=button_count&amp;show_faces=false&amp;width=100&amp;action=like&amp;colorscheme=light&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:100px; height:21px;" allowTransparency="true"></iframe>
            </div>
            <div class="span3">
                <!-- Place this tag where you want the +1 button to render -->
                <g:plusone annotation="inline" href="http://www.codingthearchitecture.com/presentations/" width="180"></g:plusone>

                <!-- Place this render call where appropriate -->
                <script type="text/javascript">
                  window.___gcfg = {lang: 'en-GB'};

                  (function() {
                    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
                    po.src = 'https://apis.google.com/js/plusone.js';
                    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
                  })();
                </script>
            </div>
        </div>
    </div>
</footer>