/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-06-21 18:51:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class block_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Block model</title>\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("        div {\r\n");
      out.write("            margin-bottom: 16px;\r\n");
      out.write("        }\r\n");
      out.write("        * {\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .outline {\r\n");
      out.write("            border: 3px dashed red;\r\n");
      out.write("            position: relative;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .inline {\r\n");
      out.write("            display: block;\r\n");
      out.write("            border: 1px solid black;\r\n");
      out.write("            width: 500px;\r\n");
      out.write("            height: 150px;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .inline2 {\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            display: block;\r\n");
      out.write("            border: 1px solid black;\r\n");
      out.write("            width: 500px;\r\n");
      out.write("            height: 150px;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 500px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .phone {\r\n");
      out.write("            width: 50px;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            background: lightseagreen;\r\n");
      out.write("            border-radius: 100px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            vertical-align: middle;\r\n");
      out.write("            color: white;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            right: 10px;\r\n");
      out.write("            top: 50%\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        span {\r\n");
      out.write("            display: inline; /* строчный */\r\n");
      out.write("            border: 1px solid red;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<a href=\"\" class=\"phone\">T</a>\r\n");
      out.write("<div class=\"outline\">\r\n");
      out.write("    <div class=\"inline\">\r\n");
      out.write("        test <span>info</span>\r\n");
      out.write("        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam cupiditate delectus eius enim eveniet nostrum\r\n");
      out.write("        perspiciatis porro similique ullam voluptatibus! Accusantium blanditiis eveniet laborum maxime necessitatibus\r\n");
      out.write("        quidem veniam vero voluptate?\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"inline2\">\r\n");
      out.write("        test <span>info</span>\r\n");
      out.write("        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam cupiditate delectus eius enim eveniet nostrum\r\n");
      out.write("        perspiciatis porro similique ullam voluptatibus! Accusantium blanditiis eveniet laborum maxime necessitatibus\r\n");
      out.write("        quidem veniam vero voluptate?\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div>\r\n");
      out.write("    <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci alias asperiores assumenda beatae culpa cum,\r\n");
      out.write("        cumque dolorem eaque eveniet harum nobis officia, quae, quaerat recusandae sunt suscipit ullam unde vel!\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>At cupiditate dolor dolore dolorem explicabo ipsam odit repudiandae saepe voluptates voluptatibus. Accusantium,\r\n");
      out.write("        animi consequuntur cumque cupiditate delectus ea fugiat laudantium? Accusamus architecto asperiores ea eum hic\r\n");
      out.write("        neque soluta temporibus!\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Alias aliquam animi aut eaque eveniet excepturi, iusto mollitia nam necessitatibus rerum ullam unde vel\r\n");
      out.write("        voluptatem! Aut cumque doloribus ducimus explicabo minus quibusdam repellat repudiandae sunt totam veniam!\r\n");
      out.write("        Eveniet, magni.\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Alias dolores, ducimus et exercitationem facere hic impedit maiores minus molestiae necessitatibus nihil\r\n");
      out.write("        officiis pariatur quos temporibus tenetur vel voluptas! Aperiam cum dolores illum ipsam laborum ratione sunt\r\n");
      out.write("        unde voluptatibus!\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Adipisci autem consectetur eius enim fugit hic ipsam ipsum itaque laborum magni nam neque, odit quod ratione\r\n");
      out.write("        veniam! Ab doloribus dolorum eaque illum iste, itaque minus praesentium quas quod quos?\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Minima nemo odit quo rerum? Alias cum sint tempora totam? Animi aut dicta excepturi exercitationem explicabo\r\n");
      out.write("        facilis fugiat, in iure, iusto magni minima odio qui quis ratione temporibus totam voluptate.\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Expedita ipsa magnam numquam quaerat quisquam! Aliquid, amet beatae debitis dicta eos et facilis nam nemo nihil\r\n");
      out.write("        officia perspiciatis quaerat quasi qui, ut vitae. Amet ducimus ipsam ipsum quis temporibus.\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Animi architecto, at dolor eaque eligendi eum excepturi, fuga illum incidunt labore laboriosam, minus modi\r\n");
      out.write("        mollitia provident quae reprehenderit repudiandae sint soluta vitae voluptate. Cupiditate ipsam obcaecati odit\r\n");
      out.write("        placeat quae!\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Assumenda commodi error fuga fugiat iste molestias nulla totam voluptatem voluptatum? Accusamus consequatur\r\n");
      out.write("        enim et exercitationem expedita natus provident quibusdam vel! Accusantium aliquam dolores expedita illo nam\r\n");
      out.write("        pariatur quasi quos.\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>Accusantium autem consequatur cupiditate iste maxime quidem voluptate. At aut molestiae molestias reiciendis,\r\n");
      out.write("        saepe tempora veniam. Aliquam animi dolor eligendi, facere impedit, ipsa maxime odio officiis quisquam, sit\r\n");
      out.write("        totam vitae!\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
