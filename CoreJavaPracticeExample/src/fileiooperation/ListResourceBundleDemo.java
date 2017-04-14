package fileiooperation;

import java.util.*;
/*properties vs list resouce bundle
 * ListResourceBundle : This is an abstract class and it manages the resources using key/value pairs. Any class extending from this should implement the method getContents.
protected abstract Object[][] getContents()
 */
class ListResourceBundleDemo
{
    public static void main(String arg[])
    {
        
        /*ResourceBundle defaultNames = ResourceBundle.getBundle("ButtonNames");
        
        System.out.println("Default/English version :");
        System.out.println("String for title Key : " + defaultNames.getString("title"));
        System.out.println("String for start Key : " + defaultNames.getString("start"));
        System.out.println("String for stop Key : " + defaultNames.getString("stop"));
        System.out.println();
        
        ResourceBundle germanNames = ResourceBundle.getBundle("ButtonNames", Locale.GERMAN);
        
        System.out.println("German version :");
        System.out.println("String for title Key : " + germanNames.getString("title"));
        System.out.println("String for start Key : " + germanNames.getString("start"));
        System.out.println("String for stop Key : " + germanNames.getString("stop"));   */
        
        
        /// using propeties
        
        ResourceBundle resource = ResourceBundle.getBundle("SampleRB_de", Locale.GERMAN);

        Properties properties = convertResourceBundleToProperties(resource);

        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
          String key = (String) keys.nextElement();
          String value = (String) properties.get(key);
          System.out.println(key + " = " + value);
        }
    }
    static Properties convertResourceBundleToProperties(ResourceBundle resource) {
        Properties properties = new Properties();

        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
          String key = keys.nextElement();
          properties.put(key, resource.getString(key));
        }

        return properties;
      }
}

// Should be placed in a separate file ButtonNames.java
 class ButtonNames extends ListResourceBundle
{
    protected Object[][] getContents()
    {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "My Program";

        resources[1][0] = "stop";
        resources[1][1] = "Please Stop";

        resources[2][0] = "start";
        resources[2][1] = "Go Ahead";

        return resources;
    }
}

// Should be placed in a separate file ButtonNames_de.java
/*class ButtonNames_de extends ListResourceBundle
{
    protected Object[][] getContents()
    {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "Mein Program";

        resources[1][0] = "stop";
        resources[1][1] = "Anschlag";

        resources[2][0] = "start";
        resources[2][1] = "Anfang";

        return resources;
    }
}*/
 
 