package top.wangxingyu.util;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;

/**
 * @author 笼中雀
 */
public class JwtUtils {
    private static final String SECRET_KEY = "9A@3rF!bq8gR&2pD5fK^m6wTzL8sB1aQ";
    public static String generateToken(int userId) {

        System.out.println("Secret Key: " + SECRET_KEY);
        try {
            return Jwts.builder()
                    .setSubject(String.valueOf(userId))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        } catch (Exception e) {
            return null;
        }
    }

    public static int getUserIdFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return Integer.parseInt(claims.getSubject());
        } catch (ExpiredJwtException e) {
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getUserIdFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            return getUserIdFromToken(token);
        }
        return -1;
    }
}
