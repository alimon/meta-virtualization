include runc.inc

# Note: this rev is before the required protocol field, update when all components
#       have been updated to match.
SRCREV_runc-docker = "9d6821d1b53908e249487741eccd567249ca1d99"
SRC_URI = "git://github.com/docker/runc.git;nobranch=1;name=runc-docker \
           file://0001-Update-to-runtime-spec-198f23f827eea397d4331d7eb048d.patch \
           file://0002-Remove-Platform-as-no-longer-in-OCI-spec.patch \
           file://0003-Update-memory-specs-to-use-int64-not-uint64.patch \
           file://0001-runc-Add-console-socket-dev-null.patch \
           file://0001-Use-correct-go-cross-compiler.patch \
          "

GO_IMPORT = "import"

EXTRA_FLAGS = "-v -x -work"

RUNC_VERSION = "1.0.0-rc3"
PROVIDES += "virtual/runc"
RPROVIDES_${PN} = "virtual/runc"
