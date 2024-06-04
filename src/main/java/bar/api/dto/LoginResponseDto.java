package bar.api.dto;

public record LoginResponseDto(String accessToken, Long expiresIn, String name) {}