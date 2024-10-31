package top.wangxingyu.jobs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.wangxingyu.entity.StockPrice;
import top.wangxingyu.mapper.StockPriceMapper;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author 笼中雀
 */

@Slf4j
//@Component
@AllArgsConstructor
public class StockPriceTask {

    private final Random random = new Random();
    private final StockPriceMapper stockPriceMapper;

    @Scheduled(fixedRate = 5000)
    public void updateStockPrice() {
        double price = 100 + random.nextDouble() * 50;
        double roundedValue=Math.round(price*100.0)/100.0;
        StockPrice stockPrice = new StockPrice();
        stockPrice.setPrice(roundedValue);
        stockPrice.setName("小米");
        stockPrice.setUpdateTime(LocalDateTime.now());

        //插入数据库
        stockPriceMapper.insert(stockPrice);
            log.info("股票价格已更新:{}.时间:{}", price, LocalDateTime.now());
    }
}
