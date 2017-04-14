package com.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public class ProcessBuilderDemo {

	public static void main(String[] args) {
		//How to run operating system specific command and read its output? - See more at: http://www.java2novice.com/java-fundamentals/process-builder/run-os-command/#sthash.0FPuxSY7.dpuf
		InputStream is = null;
        ByteArrayOutputStream baos = null;
        ProcessBuilder pb = new ProcessBuilder("ls", "-l");
        try {
            Process prs = pb.start();
            is = prs.getInputStream();
            byte[] b = new byte[1024];
            int size = 0;
            baos = new ByteArrayOutputStream();
            while((size = is.read(b)) != -1){
                baos.write(b, 0, size);
            }
            System.out.println(new String(baos.toByteArray()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                if(is != null) is.close();
                if(baos != null) baos.close();
            } catch (Exception ex){}
        }
//How to get process environment variables in java at runtime? - See more at: http://www.java2novice.com/java-fundamentals/process-builder/env-details/#sthash.i5mFRs1Q.dpuf
        
        ProcessBuilder pb1 = new ProcessBuilder();
        Map<String, String> envMap = pb1.environment();
        Set<String> keys = envMap.keySet();
        for(String key:keys){
            System.out.println(key+" ==> "+envMap.get(key));
        }
        
        // How to invoke other applicatons in java?
        /*
         * Here first argument invokes java.exe file, and sencond argument passes MyTest.classfile to java application - See more at: http://www.java2novice.com/java-fundamentals/process-builder/run-app/#sthash.s4vfBWrC.dpuf
         * You can pass any number of arguments to an application. - See more at: http://www.java2novice.com/java-fundamentals/process-builder/run-app/#sthash.s4vfBWrC.dpuf
         */
        ProcessBuilder pb2 = new ProcessBuilder("java", "MyTest"); 
        
        try {
            pb2.start();
            System.out.println("");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // Static import 
        // Static imports allow us to import all static fields and methods into a class
        // and you can access them without class name reference
	}

}
