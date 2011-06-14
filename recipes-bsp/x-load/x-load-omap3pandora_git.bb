require x-load.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=25;md5=ef08d08cb99057bbb5b9d6d0c5a4396f"

COMPATIBLE_MACHINE = "omap3-pandora"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/x-load-${MACHINE}/${MACHINE}"

SRCREV = "b3646a83f9e67ec9a2de3182fd254557fd6ad9aa"

PROVIDES = "x-load"

PV = "1.42+${PR}+gitr${SRCREV}"
PR ="r3"
PE = "1"

SRC_URI = "git://git.openpandora.org/pandora-x-loader.git;branch=master;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

XLOAD_MACHINE = "pandora_config"
