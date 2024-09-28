package budget_app.models;

import lombok.Builder;

import java.math.BigDecimal;

@lombok.Builder
public record Transaction(int userId, int accountId, int categoryId,
                          String currency, BigDecimal amount, String transType, String notes) {
}
