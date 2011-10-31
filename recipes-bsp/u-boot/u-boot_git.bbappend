COMPATIBLE_MACHINE = "omap3-pandora"
DEFAULT_PREFERENCE_omap3-pandora = "1"

# Latest SRCREV.
SRCREV_pn-${PN}_omap3-pandora = "48aa0d1c545b4085435577602f331e07c097782f"

PR ="r2"
PV_omap3-pandora = "omap3-pandora+${PR}+gitr${SRCREV}"

SRC_URI_omap3-pandora = "git://git.openpandora.org/pandora-u-boot.git;branch=master;protocol=git \
"

UBOOT_MACHINE_omap3-pandora = "omap3_pandora_config"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
