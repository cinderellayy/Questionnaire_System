package com.xeon.test;

import java.io.UnsupportedEncodingException;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.xeon.model.AllowCollege;
import com.xeon.util.impl.UtilImpl;


public class Test3 {
	public static void main(String[] args) throws UnsupportedEncodingException{
		UtilImpl u = new UtilImpl();
		Gson g = new Gson();
		//g.
		/*String json = "{\"username\":\"azdjy\",\"password\":\"fdf\"}";
		JSONObject j = JSONObject.fromObject(json);
		String s = j.getString("password");
		System.out.println(s);*/
		/*String s= "%7B%22id%22:2,%22username%22:%22agzdjy_two%22,%22account%22:%222012081402%22,%22password%22:%22836fcfd794664191bb9b203168d7f6e4%22,%22role%22:%22student%22,%22college%22:%22%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6%E4%B8%8E%E5%B7%A5%E7%A8%8B%E5%AD%A6%E9%99%A2%22,%22professional%22:%22%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6%E4%B8%8E%E6%8A%80%E6%9C%AF%22,%22grade%22:%222012%22,%22student_class%22:%226%22,%22nation%22:%22%E7%91%B6%E6%97%8F%22,%22sex%22:%22man%22%7D";
		s = URLDecoder.decode(s,"utf-8");
		System.out.println(s);*/
		
		/*User user = new User();
		user.setAccount("2012081401");
		user.setNation("汉");
		user.setPassword("174151");
		user.setSex("man");
		user.setUsername("好走是哦");
		
		String str = g.toJson(user);
		
		System.out.println("json---->"+str);
		System.out.println("encod---->"+u.encode(str));
		str = u.encode(str);
		//String str = "JTdCJTIycGFnZV9udW1iZXIlMjIlM0ExJTJDJTIybGlzdF91c2VyJTIyJTNBJTVCJTdCJTIyaWQlMjIlM0ExJTJDJTIydXNlcm5hbWUlMjIlM0ElMjJhZ3pkanklMjIlMkMlMjJhY2NvdW50JTIyJTNBJTIyMjAxMjA4MTQwMSUyMiUyQyUyMnBhc3N3b3JkJTIyJTNBJTIyZTVlMmU3NDRjOGIwODllOWY2MTliMDI1NTkxOGYzMDklMjIlMkMlMjJyb2xlJTIyJTNBJTIyYWRtaW4lMjIlMkMlMjJjb2xsZWdlJTIyJTNBJTIyJUU4JUFFJUExJUU3JUFFJTk3JUU2JTlDJUJBJUU3JUE3JTkxJUU1JUFEJUE2JUU0JUI4JThFJUU1JUI3JUE1JUU3JUE4JThCJUU1JUFEJUE2JUU5JTk5JUEyJTIyJTJDJTIycHJvZmVzc2lvbmFsJTIyJTNBJTIyJUU4JUFFJUExJUU3JUFFJTk3JUU2JTlDJUJBJUU3JUE3JTkxJUU1JUFEJUE2JUU0JUI4JThFJUU2JThBJTgwJUU2JTlDJUFGJTIyJTJDJTIyZ3JhZGUlMjIlM0ElMjIyMDEyJTIyJTJDJTIyc3R1ZGVudF9jbGFzcyUyMiUzQSUyMjQlMjIlMkMlMjJuYXRpb24lMjIlM0ElMjIlRTklQkIlOEUlRTYlOTclOEYlMjIlMkMlMjJzZXglMjIlM0ElMjJtYW4lMjIlMkMlMjJleGlzdCUyMiUzQWZhbHNlJTdEJTJDJTdCJTIyaWQlMjIlM0EyJTJDJTIydXNlcm5hbWUlMjIlM0ElMjJhZ3pkanlfdHdvJTIyJTJDJTIyYWNjb3VudCUyMiUzQSUyMjIwMTIwODE0MDIlMjIlMkMlMjJwYXNzd29yZCUyMiUzQSUyMjgzNmZjZmQ3OTQ2NjQxOTFiYjliMjAzMTY4ZDdmNmU0JTIyJTJDJTIycm9sZSUyMiUzQSUyMnN0dWRlbnQlMjIlMkMlMjJjb2xsZWdlJTIyJTNBJTIyJUU4JUFFJUExJUU3JUFFJTk3JUU2JTlDJUJBJUU3JUE3JTkxJUU1JUFEJUE2JUU0JUI4JThFJUU1JUI3JUE1JUU3JUE4JThCJUU1JUFEJUE2JUU5JTk5JUEyJTIyJTJDJTIycHJvZmVzc2lvbmFsJTIyJTNBJTIyJUU3JUJEJTkxJUU3JUJCJTlDJUU1JUI3JUE1JUU3JUE4JThCJTIyJTJDJTIyZ3JhZGUlMjIlM0ElMjIyMDEyJTIyJTJDJTIyc3R1ZGVudF9jbGFzcyUyMiUzQSUyMjMlMjIlMkMlMjJuYXRpb24lMjIlM0ElMjIlRTklOTQlQTElRTQlQkMlQUYlRTYlOTclOEYlMjIlMkMlMjJzZXglMjIlM0ElMjJ3b21hbiUyMiUyQyUyMmV4aXN0JTIyJTNBZmFsc2UlN0QlMkMlN0IlMjJpZCUyMiUzQTMlMkMlMjJ1c2VybmFtZSUyMiUzQSUyMiVFNCVCOCVBRCVFNSU5QiVCRCVFNCVCQSVCQSUyMiUyQyUyMmFjY291bnQlMjIlM0ElMjIyMDEyMDgxNDA2JTIyJTJDJTIycGFzc3dvcmQlMjIlM0ElMjI2OTcxNDNiOGYyYzE3YzFiNzBiODZmMGM5ZDlmOWE0OCUyMiUyQyUyMnJvbGUlMjIlM0ElMjJzdHVkZW50JTIyJTJDJTIyY29sbGVnZSUyMiUzQSUyMiVFOCVBRSVBMSVFNyVBRSU5NyVFNiU5QyVCQSVFNyVBNyU5MSVFNSVBRCVBNiVFNCVCOCU4RSVFNSVCNyVBNSVFNyVBOCU4QiVFNSVBRCVBNiVFOSU5OSVBMiUyMiUyQyUyMnByb2Zlc3Npb25hbCUyMiUzQSUyMiVFOCVBRSVBMSVFNyVBRSU5NyVFNiU5QyVCQSVFNyVBNyU5MSVFNSVBRCVBNiVFNCVCOCU4RSVFNiU4QSU4MCVFNiU5QyVBRiUyMiUyQyUyMmdyYWRlJTIyJTNBJTIyMjAxMiUyMiUyQyUyMnN0dWRlbnRfY2xhc3MlMjIlM0ElMjI0JTIyJTJDJTIybmF0aW9uJTIyJTNBJTIyJUU4JTkyJTk5JUU1JThGJUE0JUU2JTk3JThGJTIyJTJDJTIyc2V4JTIyJTNBJTIyd29tYW4lMjIlMkMlMjJleGlzdCUyMiUzQWZhbHNlJTdEJTJDJTdCJTIyaWQlMjIlM0E0JTJDJTIydXNlcm5hbWUlMjIlM0ElMjJhZ2RqeV90aHJlZSUyMiUyQyUyMmFjY291bnQlMjIlM0ElMjIyMDEyMDgyNDAxJTIyJTJDJTIycGFzc3dvcmQlMjIlM0ElMjJlNWUyZTc0NGM4YjA4OWU5ZjYxOWIwMjU1OTE4ZjMwOSUyMiUyQyUyMnJvbGUlMjIlM0ElMjJzdHVkZW50JTIyJTJDJTIyY29sbGVnZSUyMiUzQSUyMiVFOCVBRSVBMSVFNyVBRSU5NyVFNiU5QyVCQSVFNyVBNyU5MSVFNSVBRCVBNiVFNCVCOCU4RSVFNSVCNyVBNSVFNyVBOCU4QiVFNSVBRCVBNiVFOSU5OSVBMiUyMiUyQyUyMnByb2Zlc3Npb25hbCUyMiUzQSUyMiVFNyVCRCU5MSVFNyVCQiU5QyVFNSVCNyVBNSVFNyVBOCU4QiUyMiUyQyUyMmdyYWRlJTIyJTNBJTIyMjAxMiUyMiUyQyUyMnN0dWRlbnRfY2xhc3MlMjIlM0ElMjI0JTIyJTJDJTIybmF0aW9uJTIyJTNBJTIyJUU2JUIxJTg5JUU2JTk3JThGJTIyJTJDJTIyc2V4JTIyJTNBJTIybWFuJTIyJTJDJTIyZXhpc3QlMjIlM0FmYWxzZSU3RCU1RCU3RA==";
		System.out.println("dencode---->"+u.decode(str));*/
		/*PollModel p = new PollModel();
		p.setPoll_author("agzdjy");
		p.setPoll_description("测试");
		p.setPoll_end_time(new Date(new java.util.Date().getTime()).toString());
		p.setPoll_name("测试");
		p.setPoll_upload_time(p.getPoll_end_time());
		
	System.out.println(p.getPoll_end_time().toString());
		*/
		/*SortedSet<QuestionModel> s_q = new TreeSet<QuestionModel>();
		for(int i = 0;i<5;i++){
			QuestionModel q = new QuestionModel();
			q.setId(i+1);
			System.out.println(q.getId());
			SortedSet<OptionModel> s_o = new TreeSet<OptionModel>();
			for(int j = 0;j<2;j++){
				OptionModel o = new OptionModel();
				o.setId(j+1);
				o.setOption_name("选项1");
				//o.setQuestionModel(q);
				s_o.add(o);
			}
			
			q.setOptionModel(s_o);
			//System.out.println("fdsfd=--->"+s_q.size());
			s_q.add(q);
		}
		System.out.println("fdsfd=--->"+s_q.size());
		p.setQuestionModel(s_q);*/
		/*SortedSet<AllowCollege> s_A = new TreeSet<AllowCollege>();
		for(int i = 0;i<2;i++){
			AllowCollege a = new AllowCollege();
			a.setAllowCollegeName("fsdfd");
			a.setId(i+1);
			//a.setPoll(p);
			s_A.add(a);
		}
		p.setAllowCollege(s_A);
		System.out.println(g.toJson(s_A));*/
		String json = "{\"allowCollegeName\":\"计算机科学与工程学院\"},{\"allowCollegeName\":\"生命科学学院\"},{\"allowCollegeName\":\"外国语言文化学院\"},{\"allowCollegeName\":\"物理与材料工程学院\"}";
		//AllowCollege a = g.fromJson(json, AllowCollege.class);
		SortedSet<AllowCollege> set = new TreeSet<AllowCollege>();
		String[] s = json.split(",");
		System.out.println(s.length);
		for(String ss : s){
			AllowCollege a = g.fromJson(ss, AllowCollege.class);
			System.out.println(a.getAllowCollegeName());
		}
		//g.fromJson(json, TreeSet<AllowCollege>.class);
		//System.out.println(g.toJson(p));
		//PollModel p1 = g.fromJson(json, PollModel.class);
		//SortedSet<QuestionModel> s = p1.getQuestionModel();
	//	System.out.println(p1.getPoll_author());
	
	}
}
