package com.xeon.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
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
 * @param level是难度等级，可自由选择，可自由选择验证码中字符数量 通过length参数指定
 *
 */
public class VerificServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8911596981927849417L;
	private int width = 70;
	private int heigh = 24;
	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedImage buffImg = new BufferedImage(width,heigh,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		Random random = new Random();
		//绘制图形底板色彩
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, heigh);
		
		Font font = new Font("Arial", Font.BOLD, heigh - 2);
		g.setFont(font);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(0, 0, width - 1, heigh -1);
		
		g.setColor(Color.LIGHT_GRAY);
		
		//干扰线
		for(int i =0;i<160;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(heigh);
			int x1= random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x,y,x+x1,y+y1);
		}
		
		//将验证码绘制到图片上
		//这里面的4是指验证码有四个字符，可随意调整
		String randomCode = getSecurityCode(4,SecurityCodeLevel.Medium,false);
		g.setColor(new Color(19,34,246));
		g.setFont(new Font("Georgia", Font.BOLD, 15));
		int codeY = heigh - 10;
		for(int i=0;i<randomCode.length();i++){
			g.drawString(String.valueOf(randomCode.charAt(i)), i * 16 + 5, random.nextInt(2)+codeY);
		}
		//释放资源
		g.dispose();
		HttpSession session = req.getSession();
		session.setAttribute("VERIFYCODE", randomCode);
		
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
	/**
	 * 
	 * @author Agzdjy
	 * 生成数字
	 *
	 */
	//难度等级，是否可以重复
	public enum SecurityCodeLevel {Simple,Medium,Hard};
	public static String getSecurityCode(int length,SecurityCodeLevel level,boolean isCanRepeat){
        int len=length;//4
        char[] codes={'1','2','3','4','5','6','7','8','9',
                      'a','b','c','d','e','f','g','h','i',
                      'j','k','m','n','p','q','r','s','t',
                      'u','v','w','x','y','z','A','B','C',
                      'D','E','F','G','H','I','J','K','L',
                      'M','N','P','Q','R','S','T','U','V',
                      'W','X','Y','Z'};
        if(level==SecurityCodeLevel.Simple){
            codes=Arrays.copyOfRange(codes, 0,9);
        }else if(level==SecurityCodeLevel.Medium){
            codes=Arrays.copyOfRange(codes, 0,33);
        }
        int n=codes.length;
        if(len>n&&isCanRepeat==false){
            throw new RuntimeException(
                    String.format("调用SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)出现异常，" +
                                   "当isCanRepeat为%3$s时，传入参数%1$s不能大于%4$s",
                                   len,level,isCanRepeat,n));
        }
        char[] result=new char[len];
        if(isCanRepeat){
            for(int i=0;i<result.length;i++){
                int r=(int)(Math.random()*n);
                result[i]=codes[r];
            }
        }else{
            for(int i=0;i<result.length;i++){
            	//取0~字典长度范围
                int r=(int)(Math.random()*n);
                result[i]=codes[r];
                //将每次之后的最后一个赋值给取出的变量，再删除最后一个，这就可以保证不会出项重复
                //但如此做会使字典受损
                codes[r]=codes[n-1];
                n--;
            }
        }
        
        return String.valueOf(result);
    }
	
	
}
