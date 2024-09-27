package budget_app.models;

public record User(String username,String firstname, String lastname, String email) {

    public static class Builder {
        private String username;
        private String firstname;
        private String lastname;
        private String email;

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(username, firstname, lastname, email);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}
