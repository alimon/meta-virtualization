include runc.inc

SRCREV = "2e7cfe036e2c6dc51ccca6eb7fa3ee6b63976dcd"
SRC_URI = " \
    git://github.com/opencontainers/runc;branch=master \
    file://0001-Use-correct-go-cross-compiler.patch \
    "
RUNC_VERSION = "1.0.0-rc4"
PROVIDES += "virtual/runc"
RPROVIDES_${PN} = "virtual/runc"

GO_IMPORT = "import"

do_compile_prepend() {
	# Go looks in a src directory under any directory in GOPATH but
	# runc-opencontainers uses 'vendor' instead of 'vendor/src'. We can fix
	# this with a symlink.
	ln -sfn . "${S}/src/import/vendor/src"
}
