package com.xeon.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * @author Agzdjy
 * @生成验证码的servlet 采用servlet是为了与linux兼容
 *
 */
public class VerificServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8911596981927849417L;
	private int width = 60;
	private int heigh = 20;
	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedImage buffImg = new BufferedImage(width,heigh,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		Random random = new Random();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, heigh);
		
		Font font = new Font("Times new  Roman",Font.PLAIN,18);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, heigh-1);
		
		g.setColor(Color.GRAY);
		
		for(int i =0;i<160;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(heigh);
			int x1= random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x,y,x+x1,y+y1);
		}
		
		StringBuffer randomCode = new StringBuffer();
		int red = 0,green = 0,blue = 0;
		for(int i=0;i<4;i++){
			String strRand = String.valueOf(random.nextInt(10));
			red = random.nextInt(110);
			green = random.nextInt(50);
			blue =random.nextInt(50);
			
			g.setColor(new Color(red,green,blue));
			g.drawString(strRand, 13*i+6, 16);
			randomCode.append(strRand);
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("VERIFYCODE", randomCode.toString());
		
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
	
}
