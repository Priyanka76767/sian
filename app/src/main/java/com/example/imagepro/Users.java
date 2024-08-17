package com.example.imagepro;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*@Metadata(
        mv = {1, 7, 1},
        k = 1,
        d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"},
        d2 = {"Lcom/example/sian/Users;", "", "userId", "", "userName", "userEmail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserEmail", "()Ljava/lang/String;", "getUserId", "getUserName", "Sian.app.main"}
)*/
public final class Users {
    @NotNull
    private final String userId;
    @NotNull
    final String userName;
    @NotNull
    final String userEmail;

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    public final String getUserEmail() {
        return this.userEmail;
    }

    public Users(@NotNull String userId, @NotNull String userName, @NotNull String userEmail) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userEmail, "userEmail");
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // $FF: synthetic method
    public Users(String var1, String var2, String var3, int var4, DefaultConstructorMarker var5, @NotNull String userId, @NotNull String userName, @NotNull String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        if ((var4 & 1) != 0) {
            var1 = "";
        }

        if ((var4 & 2) != 0) {
            var2 = "";
        }

        if ((var4 & 4) != 0) {
            var3 = "";
        }

    }
}
