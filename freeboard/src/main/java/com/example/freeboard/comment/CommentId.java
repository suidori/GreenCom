package com.example.freeboard.comment;

import java.io.Serializable;
import java.util.Objects;

public class CommentId implements Serializable {
    private int c_idx;
    private long fidx;

    public CommentId() {}

    public CommentId(int c_idx, long fidx) {
        this.c_idx = c_idx;
        this.fidx = fidx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentId)) return false;
        CommentId that = (CommentId) o;
        return c_idx == that.c_idx && fidx == that.fidx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c_idx, fidx);
    }
}
