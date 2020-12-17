package buckets.framework.dictionary.core.controller;

import buckets.framework.base.common.web.BaseRestController;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buckets
 * @date 2020/11/25
 */
@Slf4j
@RestController
@RequestMapping("/logging")
public class LoggingLevelRestController extends BaseRestController {


    @ApiOperation(value = "获取日志等级", notes = "")
    @GetMapping("/get")
    public Map<String,Object> getLevel(@RequestParam("package")String pack){
        Map<String,Object> map = new HashMap<>(2);
        map.put("package",pack);
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        map.put("logger",loggerContext.getLogger(pack));
        map.put("class",loggerContext.getClass());
        return map;
    }

    @GetMapping("/update")
    public void update(@RequestParam("package")String pack,@RequestParam("level")String levelStr){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Level level;
        switch (levelStr.toUpperCase()) {
            case "TRACE":
                level = Level.TRACE;
                break;
            case "DEBUG":
                level = Level.DEBUG;
                break;
            case "INFO":
                level = Level.INFO;
                break;
            case "WARN":
                level = Level.WARN;
                break;
            case "ERROR":
                level = Level.ERROR;
                break;
            default:
                level = Level.WARN;
                break;
        }
        loggerContext.getLogger(pack).setLevel(level);

    }


    @GetMapping("/logging")
    public void getLevel(){
        log.trace("我是trace");
        log.debug("我是debug");
        log.info("我是info");
        log.warn("我是warn");
        log.error("我是error");
    }
}
