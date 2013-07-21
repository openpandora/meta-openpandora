DESCRIPTION = "SysV style init scripts to support bringing up the TI WL1251 WiFi chip found on the OpenPandora"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r1"

# The assumption that the modules are built in the kernel config as modules is made 
# (or the scripts will have no driver to load)

SRC_URI += " \
	file://rc.wl1251 \
"

inherit update-rc.d

INITSCRIPT_NAME = "wl1251-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

do_install() {
          install -d ${D}${sysconfdir}/init.d/
          install -m 0755 ${WORKDIR}/rc.wl1251 ${D}${sysconfdir}/init.d/wl1251-init
}
