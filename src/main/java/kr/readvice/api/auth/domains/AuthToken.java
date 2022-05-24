package kr.readvice.api.auth.domains;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log //토큰 발급에 대한 로그찍기
public class AuthToken {
    private String token;
    private String key;

    public AuthToken(String key) {
        this.key = key;
        this.token = createToken();
    }

    private String createToken() {
        try{
            Map<String, Object> headers = new HashMap<>();
            headers.put("typ","JWT");
            headers.put("alg","ES256");
            Map<String, Object> payload = new HashMap<>();
            payload.put("data","dummy");
            Date ext = new Date();
            ext.setTime(ext.getTime() + 1000 * 6L * 10L); //10분
            return Jwts.builder()
                    .setHeader(headers)
                    .setClaims(payload)
                    .setSubject("user")
                    .setExpiration(ext)
                    .signWith(SignatureAlgorithm.ES256, key.getBytes())
                    .compact();
        }  //토큰을 발급받을려고 시도하는 것 자체도 찍힌다.
        catch (SecurityException e){log.info("SecurityException JWT");} //보안
        catch (MalformedJwtException e){log.info("MalformedJwtException JWT");}
        catch (ExpiredJwtException e){log.info("ExpiredJwtException JWT");}
        catch (UnsupportedJwtException e){log.info("UnsupportedJwtException JWT");}
        catch (IllegalAccessError e){log.info("IllegalAccessError JWT");}
        return null;
    }
}
