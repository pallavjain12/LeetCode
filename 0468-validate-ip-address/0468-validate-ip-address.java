class Solution {
    public String validIPAddress(String ip) {
        if (ip.length() == 0 || ip.length() >= 41)   return "Neither";
        
        int ipType = 0;
        
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                ipType = 1;
                break;
            }
            else if (ip.charAt(i) == ':') {
                ipType = 2;
                break;
            }
        }
        if (ipType == 1)    return checkIPv4(ip);
        else if (ipType == 2)   return checkIPv6(ip);
        else    return "Neither";
    }
    
    private static String checkIPv4(String s) {
        if (s.charAt(0) == '.' || s.charAt(s.length()-1) == '.')    return "Neither";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' || (s.charAt(i) >= 48 && s.charAt(i) <= 57))
                continue;
            else
                return "Neither";
            
        }
        String[] arr = s.split("\\.");
        if (arr.length != 4)  {
            return "Neither";
        }
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.length() == 0) {
                return "Neither";
            }
            if (str.charAt(0) == '0' && str.length() != 1) {
                return "Neither";
            }
            if (Integer.parseInt(str) > 255)
                return "Neither";
        }
        return "IPv4";
    }
    
    private static String checkIPv6(String s) {
        if (s.charAt(0) == ':' || s.charAt(s.length()-1) == ':')    return "Neither";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':' || (s.charAt(i) >= 48 && s.charAt(i) <= 57) || (s.charAt(i) >= 65 && s.charAt(i) <= 70) || (s.charAt(i) >= 97 && s.charAt(i) <= 102))
                continue;
            else 
                return "Neither";
        }
        String[] arr = s.split(":");
        System.out.println(arr.length);
        if (arr.length != 8)    return "Neither";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == 0) return "Neither";
            if (arr[i].length() >= 5) return "Neither";
        }
        return "IPv6";
    }
}