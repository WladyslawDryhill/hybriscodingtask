<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="tabhead">
	<a href="">${fn:escapeXml(title)}</a> <span class="glyphicon"></span>
</div>
<div class="tabbody">
	<div class="container-lg">
		<div class="row">
			<div class="col-md-6 col-lg-4">
				<div class="tab-container">
					<product:productDetailsTab product="${product}" />
                    <c:if test="${not empty product.warrantyMonth}">
					  <c:out value="Warranty : ${product.warrantyMonth} month(s)" />
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

