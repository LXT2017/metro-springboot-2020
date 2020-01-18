package com.mt.metro.entity;

import java.io.Serializable;

public class Parameter implements Serializable {
    private Integer id;

    private String puzzleMusic;

    private String gameMusic;

    private String puzzlePic;

    private String gamePic;

    private Integer totalStrength;

    private Integer addition;

    public Parameter(Integer id, String puzzleMusic, String gameMusic, String puzzlePic, String gamePic, Integer totalStrength, Integer addition) {
        this.id = id;
        this.puzzleMusic = puzzleMusic;
        this.gameMusic = gameMusic;
        this.puzzlePic = puzzlePic;
        this.gamePic = gamePic;
        this.totalStrength = totalStrength;
        this.addition = addition;
    }

    public Parameter() {
        super();
    }

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

    public Integer getTotalStrength() {
        return totalStrength;
    }

    public void setTotalStrength(Integer totalStrength) {
        this.totalStrength = totalStrength;
    }

    public Integer getAddition() {
        return addition;
    }

    public void setAddition(Integer addition) {
        this.addition = addition;
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
        sb.append(", totalStrength=").append(totalStrength);
        sb.append(", addition=").append(addition);
        sb.append("]");
        return sb.toString();
    }
}