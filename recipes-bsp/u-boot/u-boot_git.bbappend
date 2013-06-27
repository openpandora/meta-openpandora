# Extends the core U-Boot GIT recipe in meta-texasinstruments 
# to suit the OpenPandora GIT tree.

# Also overwries the license checksum to suit the updated text file in our U-Boot snapshot.
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "openpandora"
DEFAULT_PREFERENCE_openpandora = "1"

# Latest SRCREV.
SRCREV_pn-${PN}_openpandora = "20e1f77c88d5e78475e208f5642ed0a7ed3f9dc7"

PR ="r7"
PV_openpandora = "omap3-pandora+${PR}+gitr${SRCREV}"

SRC_URI_openpandora = "git://github.com/urjaman/pandora-u-boot.git;branch=pandora-2013.07-rc1;protocol=git \
"

UBOOT_MACHINE_openpandora = "omap3_pandora_config"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
