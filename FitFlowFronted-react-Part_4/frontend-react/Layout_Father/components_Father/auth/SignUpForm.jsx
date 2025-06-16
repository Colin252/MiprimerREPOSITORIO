// ...importaciones

export default function SignUpForm() {
  const [showPassword, setShowPassword] = useState(false);
  const [isChecked, setIsChecked] = useState(false);
  const [isSubmitting, setIsSubmitting] = useState(false);

  const [formData, setFormData] = useState({
    fname: "",
    lname: "",
    email: "",
    password: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const validateForm = () => {
    const { fname, lname, email, password } = formData;
    if (!fname || !lname || !email || !password) {
      alert("Please fill in all required fields.");
      return false;
    }

    const isValidEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    if (!isValidEmail) {
      alert("Please enter a valid email address.");
      return false;
    }

    if (!isChecked) {
      alert("You must accept the terms and conditions.");
      return false;
    }

    return true;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!validateForm()) return;

    setIsSubmitting(true);

    const userToSend = {
      name: `${formData.fname} ${formData.lname}`,
      email: formData.email,
      password: formData.password
    };

    try {
      const response = await fetch("http://localhost:8080/api/users", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userToSend),
      });

      if (response.ok) {
        alert("Account created successfully!");
        navigate("/signin");
      } else {
        const error = await response.json();
        alert(error.message || "Something went wrong.");
      }
    } catch (error) {
      console.error("Signup failed:", error);
      alert("Server error. Please try again later.");
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
      <div className="flex flex-col flex-1 w-full overflow-y-auto lg:w-1/2 no-scrollbar">
        <div className="w-full max-w-md mx-auto mb-5 sm:pt-10">
          <Link
              to="/"
              className="inline-flex items-center text-sm text-gray-500 transition-colors hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300"
          >
            <ChevronLeftIcon className="size-5" />
            Back to dashboard
          </Link>
        </div>
        <div className="flex flex-col justify-center flex-1 w-full max-w-md mx-auto">
          <div>
            <div className="mb-5 sm:mb-8">
              <h1 className="mb-2 font-semibold text-gray-800 text-title-sm dark:text-white/90 sm:text-title-md">
                Sign Up
              </h1>
              <p className="text-sm text-gray-500 dark:text-gray-400">
                Enter your email and password to sign up!
              </p>
            </div>
            <form onSubmit={handleSubmit}>
              <div className="space-y-5">
                <div className="grid grid-cols-1 gap-5 sm:grid-cols-2">
                  <div className="sm:col-span-1">
                    <Label>
                      First Name<span className="text-error-500">*</span>
                    </Label>
                    <Input
                        type="text"
                        id="fname"
                        name="fname"
                        placeholder="Enter your first name"
                        value={formData.fname}
                        onChange={handleChange}
                    />
                  </div>
                  <div className="sm:col-span-1">
                    <Label>
                      Last Name<span className="text-error-500">*</span>
                    </Label>
                    <Input
                        type="text"
                        id="lname"
                        name="lname"
                        placeholder="Enter your last name"
                        value={formData.lname}
                        onChange={handleChange}
                    />
                  </div>
                </div>

                {/* 👇 Campo de ejemplo agregado como pediste */}
                <input placeholder="Ingresa tu email" className="w-full border px-3 py-2 rounded" />

                <div>
                  <Label>
                    Email<span className="text-error-500">*</span>
                  </Label>
                  <Input
                      type="email"
                      id="email"
                      name="email"
                      placeholder="Enter your email"
                      value={formData.email}
                      onChange={handleChange}
                  />
                </div>
                <div>
                  <Label>
                    Password<span className="text-error-500">*</span>
                  </Label>
                  <div className="relative">
                    <Input
                        placeholder="Enter your password"
                        type={showPassword ? "text" : "password"}
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                    />
                    <span
                        onClick={() => setShowPassword(!showPassword)}
                        className="absolute z-30 -translate-y-1/2 cursor-pointer right-4 top-1/2"
                    >
                    {showPassword ? (
                        <EyeIcon className="fill-gray-500 dark:fill-gray-400 size-5" />
                    ) : (
                        <EyeCloseIcon className="fill-gray-500 dark:fill-gray-400 size-5" />
                    )}
                  </span>
                  </div>
                </div>
                <div className="flex items-center gap-3">
                  <Checkbox
                      className="w-5 h-5"
                      checked={isChecked}
                      onChange={() => setIsChecked(!isChecked)}
                  />
                  <p className="inline-block font-normal text-gray-500 dark:text-gray-400">
                    By creating an account you agree to the{" "}
                    <span className="text-gray-800 dark:text-white/90">
                    Terms and Conditions,
                  </span>{" "}
                    and our{" "}
                    <span className="text-gray-800 dark:text-white">
                    Privacy Policy
                  </span>
                  </p>
                </div>
                <div>
                  <button
                      type="submit"
                      disabled={isSubmitting}
                      className={`flex items-center justify-center w-full px-4 py-3 text-sm font-medium text-white transition rounded-lg shadow-theme-xs ${
                          isSubmitting
                              ? "bg-brand-300 cursor-not-allowed"
                              : "bg-brand-500 hover:bg-brand-600"
                      }`}
                  >
                    {isSubmitting ? "Creating Account..." : "Sign Up"}
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
  );
}
