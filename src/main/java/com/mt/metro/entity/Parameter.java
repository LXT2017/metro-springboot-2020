package com.mt.metro.entity;

public class Parameter {
    private Integer id;

    private String puzzleMusic;

    private String gameMusic;

    private String puzzlePic;

    private String gamePic;

    private Integer addition;

    private Integer totalStrength;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuzzleMusic() {
        return puzzleMusic;
    }

    public void setPuzzleMusic(String puzzleMusic) {
        this.puzzleMusic = puzzleMusic == null ? null : puzzleMusic.trim();
    }

    public String getGameMusic() {
        return gameMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic == null ? null : gameMusic.trim();
    }

    public String getPuzzlePic() {
        return puzzlePic;
    }

    public void setPuzzlePic(String puzzlePic) {
        this.puzzlePic = puzzlePic == null ? null : puzzlePic.trim();
    }

    public String getGamePic() {
        return gamePic;
    }

    public void setGamePic(String gamePic) {
        this.gamePic = gamePic == null ? null : gamePic.trim();
    }

    public Integer getAddition() {
        return addition;
    }

    public void setAddition(Integer addition) {
        this.addition = addition;
    }

    public Integer getTotalStrength() {
        return totalStrength;
    }

    public void setTotalStrength(Integer totalStrength) {
        this.totalStrength = totalStrength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", puzzleMusic=").append(puzzleMusic);
        sb.append(", gameMusic=").append(gameMusic);
        sb.append(", puzzlePic=").append(puzzlePic);
        sb.append(", gamePic=").append(gamePic);
        sb.append(", addition=").append(addition);
        sb.append(", totalStrength=").append(totalStrength);
        sb.append("]");
        return sb.toString();
    }
}