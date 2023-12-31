package pedro.almeida.financialcontrol.web.dtos.response;

import pedro.almeida.financialcontrol.domain.models.Transaction;
import pedro.almeida.financialcontrol.domain.models.TransactionType;
import pedro.almeida.financialcontrol.web.config.ConfigConstants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

public record TransactionResponseDTO(
        UUID id,
        String title,
        String description,
        BigDecimal value,
        TransactionType type,
        Month currentMonth,
        LocalDate date,
        String time
) {

    public TransactionResponseDTO(Transaction transaction) {
        this(
            transaction.getId(),
            transaction.getTitle(),
            transaction.getDescription(),
            transaction.getValue(),
            transaction.getType(),
            transaction.getCurrentMonth(),
            transaction.getDate(),
            transaction.getTime().format(ConfigConstants.TRANSACTION_TIME_FORMATTER)
        );
    }

    public static List<TransactionResponseDTO> toTransactionDTO(List<Transaction> transactions) {
        return transactions.stream().map(TransactionResponseDTO::new).toList();
    }

}
