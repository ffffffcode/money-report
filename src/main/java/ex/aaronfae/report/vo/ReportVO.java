package ex.aaronfae.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {

    @NotNull(message = "请填写姓名")
    @NotEmpty(message = "请填写姓名")
    private String realName;
    @NotNull(message = "请填写价格")
    @Digits(integer = 19, fraction = 2)
    @DecimalMin("0.00")
    private BigDecimal price;
    @NotNull(message = "请选择时间")
    @NotEmpty(message = "请选择时间")
    private String contributingTime;
    @NotNull(message = "请填写用途")
    @NotEmpty(message = "请填写用途")
    private String intention;
}
