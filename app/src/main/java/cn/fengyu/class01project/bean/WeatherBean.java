package cn.fengyu.class01project.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherBean {

    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private ResultDTO result;
    @SerializedName("error_code")
    private Integer errorCode;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public static class ResultDTO {
        @SerializedName("city")
        private String city;
        @SerializedName("realtime")
        private RealtimeDTO realtime;
        @SerializedName("future")
        private List<FutureDTO> future;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public RealtimeDTO getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeDTO realtime) {
            this.realtime = realtime;
        }

        public List<FutureDTO> getFuture() {
            return future;
        }

        public void setFuture(List<FutureDTO> future) {
            this.future = future;
        }

        public static class RealtimeDTO {
            @SerializedName("temperature")
            private Integer temperature;
            @SerializedName("humidity")
            private Integer humidity;
            @SerializedName("weather")
            private String weather;
            @SerializedName("wid")
            private String wid;
            @SerializedName("direct")
            private String direct;
            @SerializedName("power")
            private String power;
            @SerializedName("aqi")
            private String aqi;

            public Integer getTemperature() {
                return temperature;
            }

            public void setTemperature(Integer temperature) {
                this.temperature = temperature;
            }

            public Integer getHumidity() {
                return humidity;
            }

            public void setHumidity(Integer humidity) {
                this.humidity = humidity;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }
        }

        public static class FutureDTO {
            @SerializedName("date")
            private String date;
            @SerializedName("temperature")
            private String temperature;
            @SerializedName("weather")
            private String weather;
            @SerializedName("wid")
            private WidDTO wid;
            @SerializedName("direct")
            private String direct;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WidDTO getWid() {
                return wid;
            }

            public void setWid(WidDTO wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public static class WidDTO {
                @SerializedName("day")
                private String day;
                @SerializedName("night")
                private String night;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getNight() {
                    return night;
                }

                public void setNight(String night) {
                    this.night = night;
                }
            }
        }
    }
}
