
public abstract class AttackCreator {
	
	private static Attack[] brunoStandingRight, brunoStandingLeft, brunoWalkingRight, brunoWalkingLeft, brunoJabRight, brunoJabLeft, 
							brunoShieldingRight, brunoShieldHitRight, brunoShieldingLeft, brunoShieldHitLeft, brunoDashRight, brunoDashLeft, 
							brunoUpTiltRight, brunoUpTiltLeft, brunoBairRight, brunoBairLeft, brunoFairRight, brunoFairLeft, 
							brunoUpAirRight, brunoUpAirLeft, brunoSideSpecialRight, brunoSideSpecialLeft,
							brunoNeutralSpecialRight, brunoNeutralSpecialLeft, brunoUpSpecialRight, brunoUpSpecialLeft,
							
							carolStandingRight, carolStandingLeft, carolWalkingRight, carolWalkingLeft, carolJabRight, carolJabLeft,
							carolShieldingRight, carolShieldHitRight, carolShieldingLeft, carolShieldHitLeft, carolDashRight, carolDashLeft,
							carolUpTiltRight, carolUpTiltLeft, carolBairRight, carolBairLeft, carolFairRight, carolFairLeft,
							carolUpAirRight, carolUpAirLeft, carolSideSpecialRight, carolSideSpecialLeft,
							carolNeutralSpecialRight, carolNeutralSpecialLeft, carolUpSpecialRight, carolUpSpecialLeft,
							
							lacerdaStandingRight, lacerdaStandingLeft, lacerdaWalkingRight, lacerdaWalkingLeft, lacerdaJabRight, lacerdaJabLeft,
							lacerdaShieldingRight, lacerdaShieldHitRight, lacerdaShieldingLeft, lacerdaShieldHitLeft, lacerdaDashRight, lacerdaDashLeft,
							lacerdaUpTiltRight, lacerdaUpTiltLeft, lacerdaBairRight, lacerdaBairLeft, lacerdaFairRight, lacerdaFairLeft,
							lacerdaUpAirRight, lacerdaUpAirLeft, lacerdaSideSpecial1Right, lacerdaSideSpecial1Left, 
							lacerdaSideSpecial2Right, lacerdaSideSpecial2Left, lacerdaSideSpecial3Right, lacerdaSideSpecial3Left,
							lacerdaNeutralSpecial1Right, lacerdaNeutralSpecial1Left, lacerdaNeutralSpecial2Right, lacerdaNeutralSpecial2Left, 
							lacerdaUpSpecialRight, lacerdaUpSpecialLeft,
	
							obinoStandingRight, obinoStandingLeft, obinoWalkingRight, obinoWalkingLeft, obinoJabRight, obinoJabLeft,
							obinoShieldingRight, obinoShieldHitRight, obinoShieldingLeft, obinoShieldHitLeft, obinoDashRight, obinoDashLeft,
							obinoUpTiltRight, obinoUpTiltLeft, obinoBairRight, obinoBairLeft, obinoFairRight, obinoFairLeft, 
							obinoUpAirRight, obinoUpAirLeft, obinoSideSpecialRight, obinoSideSpecialLeft,
							obinoNeutralSpecialRight, obinoNeutralSpecialLeft, obinoUpSpecialRight, obinoUpSpecialLeft;
							
	
	private static Hitbox[] brunoJabRightHitboxes, brunoJabLeftHitboxes,
							brunoDashRightHitboxes0, brunoDashRightHitboxes1, brunoDashRightHitboxes2,
							brunoDashLeftHitboxes0, brunoDashLeftHitboxes1, brunoDashLeftHitboxes2,
							brunoUpTiltRightHitboxes0, brunoUpTiltRightHitboxes1, brunoUpTiltRightHitboxes2,
							brunoUpTiltLeftHitboxes0, brunoUpTiltLeftHitboxes1, brunoUpTiltLeftHitboxes2,
							brunoBairRightHitboxes, brunoBairLeftHitboxes,
							brunoFairRightHitboxes0, brunoFairRightHitboxes1, brunoFairRightHitboxes2,
							brunoFairLeftHitboxes0, brunoFairLeftHitboxes1, brunoFairLeftHitboxes2,
							brunoUpAirRightHitboxes, brunoUpAirLeftHitboxes,
	
							carolJabRightHitboxes0, carolJabRightHitboxes1, carolJabRightHitboxes2,
							carolJabLeftHitboxes0, carolJabLeftHitboxes1, carolJabLeftHitboxes2,
							carolDashRightHitboxes0, carolDashRightHitboxes1, carolDashRightHitboxes2, carolDashRightHitboxes3,
							carolDashLeftHitboxes0, carolDashLeftHitboxes1, carolDashLeftHitboxes2, carolDashLeftHitboxes3,
							carolUpTiltRightHitboxes0, carolUpTiltRightHitboxes1, carolUpTiltRightHitboxes2, carolUpTiltRightHitboxes3,
							carolUpTiltRightHitboxes4, carolUpTiltRightHitboxes5, carolUpTiltRightHitboxes6,
							carolUpTiltLeftHitboxes0, carolUpTiltLeftHitboxes1, carolUpTiltLeftHitboxes2, carolUpTiltLeftHitboxes3,
							carolUpTiltLeftHitboxes4, carolUpTiltLeftHitboxes5, carolUpTiltLeftHitboxes6,
							carolBairRightHitboxes, carolBairLeftHitboxes,
							carolFairRightHitboxes0, carolFairRightHitboxes1, carolFairRightHitboxes2, carolFairRightHitboxes3,
							carolFairLeftHitboxes0, carolFairLeftHitboxes1, carolFairLeftHitboxes2, carolFairLeftHitboxes3,
							carolUpAirHitboxes,
							
							lacerdaJabRightHitboxes, lacerdaJabLeftHitboxes,
							lacerdaDashRightHitboxes, lacerdaDashLeftHitboxes,
							lacerdaUpTiltRightHitboxes0, lacerdaUpTiltRightHitboxes1,
							lacerdaUpTiltLeftHitboxes0, lacerdaUpTiltLeftHitboxes1,
							lacerdaBairRightHitboxes, lacerdaBairLeftHitboxes,
							lacerdaFairRightHitboxes0, lacerdaFairRightHitboxes1, lacerdaFairRightHitboxes2,
							lacerdaFairLeftHitboxes0, lacerdaFairLeftHitboxes1, lacerdaFairLeftHitboxes2,
							lacerdaUpAirRightHitboxes0, lacerdaUpAirRightHitboxes1, lacerdaUpAirRightHitboxes2,
							lacerdaUpAirLeftHitboxes0, lacerdaUpAirLeftHitboxes1, lacerdaUpAirLeftHitboxes2,
							lacerdaSideSpecial1RightHitboxes, lacerdaSideSpecial1LeftHitboxes,
							lacerdaSideSpecial2RightHitboxes, lacerdaSideSpecial2LeftHitboxes,
							lacerdaSideSpecial3RightHitboxes, lacerdaSideSpecial3LeftHitboxes,
							lacerdaNeutralSpecial2RightHitboxes0, lacerdaNeutralSpecial2RightHitboxes1, lacerdaNeutralSpecial2RightHitboxes2,
							lacerdaNeutralSpecial2RightHitboxes3, lacerdaNeutralSpecial2RightHitboxes4,
							lacerdaNeutralSpecial2LeftHitboxes0, lacerdaNeutralSpecial2LeftHitboxes1, lacerdaNeutralSpecial2LeftHitboxes2,
							lacerdaNeutralSpecial2LeftHitboxes3, lacerdaNeutralSpecial2LeftHitboxes4,
							lacerdaUpSpecialRightHitboxes, lacerdaUpSpecialLeftHitboxes,
							
							obinoJabRightHitboxes, obinoJabLeftHitboxes,
							obinoDashRightHitboxes0, obinoDashRightHitboxes1, obinoDashLeftHitboxes0, obinoDashLeftHitboxes1, 
							obinoUpTiltRightHitboxes0, obinoUpTiltRightHitboxes1, obinoUpTiltRightHitboxes2,
							obinoUpTiltLeftHitboxes0, obinoUpTiltLeftHitboxes1, obinoUpTiltLeftHitboxes2,
							obinoBairRightHitboxes, obinoBairLeftHitboxes,
							obinoFairRightHitboxes0, obinoFairRightHitboxes1, obinoFairRightHitboxes2,
							obinoFairLeftHitboxes0, obinoFairLeftHitboxes1, obinoFairLeftHitboxes2,
							obinoUpAirRightHitboxes, obinoUpAirLeftHitboxes,
							obinoSideSpecialRightHitboxes, obinoSideSpecialLeftHitboxes;
				
							
	
	private static Hurtbox[] brunoStandingRightHurtboxes, brunoStandingLeftHurtboxes,
							 brunoWalkingRightHurtboxes0, brunoWalkingRightHurtboxes1,
							 brunoWalkingLeftHurtboxes0, brunoWalkingLeftHurtboxes1,
							 brunoJabRightHurtboxes0, brunoJabRightHurtboxes1, brunoJabRightHurtboxes2, brunoJabRightHurtboxes3, 
							 brunoJabLeftHurtboxes0, brunoJabLeftHurtboxes1, brunoJabLeftHurtboxes2, brunoJabLeftHurtboxes3,
							 brunoShieldingHurtbox,
							 brunoDashRightHurtboxes0, brunoDashRightHurtboxes1, brunoDashRightHurtboxes2, brunoDashRightHurtboxes3, brunoDashRightHurtboxes4,
							 brunoDashLeftHurtboxes0, brunoDashLeftHurtboxes1, brunoDashLeftHurtboxes2, brunoDashLeftHurtboxes3, brunoDashLeftHurtboxes4,
							 brunoUpTiltRightHurtboxes0,  brunoUpTiltRightHurtboxes1,  brunoUpTiltRightHurtboxes2,  brunoUpTiltRightHurtboxes3,
							 brunoUpTiltLeftHurtboxes0, brunoUpTiltLeftHurtboxes1, brunoUpTiltLeftHurtboxes2, brunoUpTiltLeftHurtboxes3,
							 brunoBairRightHurtboxes0, brunoBairRightHurtboxes1, brunoBairRightHurtboxes2,
							 brunoBairLeftHurtboxes0, brunoBairLeftHurtboxes1, brunoBairLeftHurtboxes2,
							 brunoFairRightHurtboxes, brunoFairLeftHurtboxes,
							 brunoUpAirRightHurtboxes0,  brunoUpAirRightHurtboxes1, brunoUpAirLeftHurtboxes0, brunoUpAirLeftHurtboxes1,
							 
							 carolStandingRightHurtboxes, carolStandingLeftHurtboxes,
							 carolWalkingRightHurtboxes, carolWalkingLeftHurtboxes,
							 carolShieldingHurtbox,
							 carolJabRightHurtboxes0, carolJabRightHurtboxes1,
							 carolJabLeftHurtboxes0, carolJabLeftHurtboxes1,
							 carolDashRightHurtboxes0, carolDashLeftHurtboxes0, carolDashRightHurtboxes1, carolDashLeftHurtboxes1,
							 carolBairRightHurtboxes, carolBairLeftHurtboxes,
							 
							 lacerdaJabRightHurtboxes0, lacerdaJabRightHurtboxes1, lacerdaJabRightHurtboxes2,
							 lacerdaJabLeftHurtboxes0, lacerdaJabLeftHurtboxes1, lacerdaJabLeftHurtboxes2,
							 lacerdaDashRightHurtboxes0, lacerdaDashRightHurtboxes1, lacerdaDashRightHurtboxes2,
							 lacerdaDashLeftHurtboxes0, lacerdaDashLeftHurtboxes1, lacerdaDashLeftHurtboxes2,
							 lacerdaUpTiltRightHurtboxes0, lacerdaUpTiltRightHurtboxes1, lacerdaUpTiltRightHurtboxes2, lacerdaUpTiltRightHurtboxes3,
							 lacerdaUpTiltLeftHurtboxes0, lacerdaUpTiltLeftHurtboxes1, lacerdaUpTiltLeftHurtboxes2, lacerdaUpTiltLeftHurtboxes3,
							 lacerdaBairRightHurtboxes0, lacerdaBairRightHurtboxes1, lacerdaBairRightHurtboxes2, lacerdaBairRightHurtboxes3,
							 lacerdaBairLeftHurtboxes0, lacerdaBairLeftHurtboxes1, lacerdaBairLeftHurtboxes2, lacerdaBairLeftHurtboxes3,
							 lacerdaNeutralSpecial1RightHurtboxes, lacerdaNeutralSpecial1LeftHurtboxes,
							 
							 obinoDashRightHurtboxes0, obinoDashRightHurtboxes1, obinoDashRightHurtboxes2,
							 obinoDashLeftHurtboxes0, obinoDashLeftHurtboxes1, obinoDashLeftHurtboxes2,
							 obinoBairRightHurtboxes0, obinoBairRightHurtboxes1, obinoBairRightHurtboxes2,
							 obinoBairLeftHurtboxes0, obinoBairLeftHurtboxes1, obinoBairLeftHurtboxes2,
							 obinoUpAirRightHurtboxes0, obinoUpAirRightHurtboxes1,
							 obinoUpAirLeftHurtboxes0, obinoUpAirLeftHurtboxes1,
							 obinoUpSpecialRightHurtboxes0, obinoUpSpecialRightHurtboxes1, obinoUpSpecialRightHurtboxes2,
							 obinoUpSpecialLeftHurtboxes0, obinoUpSpecialLeftHurtboxes1, obinoUpSpecialLeftHurtboxes2;
	
	
	private static Counterbox[] lacerdaNeutralSpecial1RightCounterboxes, lacerdaNeutralSpecial1LeftCounterboxes;
							
	
	
	
	private static AttackFrame[] brunoParryRightFrames, brunoParryLeftFrames;
	private static AttackFrame[][] brunoWalkingRightFrames;
	private static AttackFrame[][] brunoWalkingLeftFrames;
	private static AttackFrame[][] brunoJabRightFrames;
	private static AttackFrame[][] brunoJabLeftFrames;
	private static AttackFrame[][] brunoStandingRightFrames;
	private static AttackFrame[][] brunoStandingLeftFrames;
	private static AttackFrame[][] brunoShieldingRightFrames;
	private static AttackFrame[][] brunoShieldHitRightFrames;
	private static AttackFrame[][] brunoShieldingLeftFrames;
	private static AttackFrame[][] brunoShieldHitLeftFrames;
	private static AttackFrame[][] brunoDashRightFrames;
	private static AttackFrame[][] brunoDashLeftFrames;
	private static AttackFrame[][] brunoUpTiltRightFrames;
	private static AttackFrame[][] brunoUpTiltLeftFrames;
	private static AttackFrame[][] brunoBairRightFrames;
	private static AttackFrame[][] brunoBairLeftFrames;
	private static AttackFrame[][] brunoFairRightFrames;
	private static AttackFrame[][] brunoFairLeftFrames;
	private static AttackFrame[][] brunoUpAirRightFrames;
	private static AttackFrame[][] brunoUpAirLeftFrames;
	private static AttackFrame[][] brunoSideSpecialRightFrames;
	private static AttackFrame[][] brunoSideSpecialLeftFrames;
	private static AttackFrame[][] brunoNeutralSpecialRightFrames;
	private static AttackFrame[][] brunoNeutralSpecialLeftFrames;
	private static AttackFrame[][] brunoUpSpecialRightFrames;
	private static AttackFrame[][] brunoUpSpecialLeftFrames;
	
	private static AttackFrame[] carolParryRightFrames, carolParryLeftFrames;
	private static AttackFrame[][] carolStandingRightFrames;
	private static AttackFrame[][] carolStandingLeftFrames;
	private static AttackFrame[][] carolWalkingRightFrames;
	private static AttackFrame[][] carolWalkingLeftFrames;
	private static AttackFrame[][] carolShieldingRightFrames;
	private static AttackFrame[][] carolShieldHitRightFrames;
	private static AttackFrame[][] carolShieldingLeftFrames;
	private static AttackFrame[][] carolShieldHitLeftFrames;
	private static AttackFrame[][] carolJabRightFrames;
	private static AttackFrame[][] carolJabLeftFrames;
	private static AttackFrame[][] carolDashRightFrames;
	private static AttackFrame[][] carolDashLeftFrames;
	private static AttackFrame[][] carolUpTiltRightFrames;
	private static AttackFrame[][] carolUpTiltLeftFrames;
	private static AttackFrame[][] carolBairRightFrames;
	private static AttackFrame[][] carolBairLeftFrames;
	private static AttackFrame[][] carolFairRightFrames;
	private static AttackFrame[][] carolFairLeftFrames;
	private static AttackFrame[][] carolUpAirRightFrames;
	private static AttackFrame[][] carolUpAirLeftFrames;
	private static AttackFrame[][] carolSideSpecialRightFrames;
	private static AttackFrame[][] carolSideSpecialLeftFrames;
	private static AttackFrame[][] carolNeutralSpecialRightFrames;
	private static AttackFrame[][] carolNeutralSpecialLeftFrames;
	private static AttackFrame[][] carolUpSpecialRightFrames;
	private static AttackFrame[][] carolUpSpecialLeftFrames;
	
	private static AttackFrame[] lacerdaParryRightFrames, lacerdaParryLeftFrames;
	private static AttackFrame[][] lacerdaWalkingRightFrames;
	private static AttackFrame[][] lacerdaWalkingLeftFrames;
	private static AttackFrame[][] lacerdaJabRightFrames;
	private static AttackFrame[][] lacerdaJabLeftFrames;
	private static AttackFrame[][] lacerdaStandingRightFrames;
	private static AttackFrame[][] lacerdaStandingLeftFrames;
	private static AttackFrame[][] lacerdaShieldingRightFrames;
	private static AttackFrame[][] lacerdaShieldHitRightFrames;
	private static AttackFrame[][] lacerdaShieldingLeftFrames;
	private static AttackFrame[][] lacerdaShieldHitLeftFrames;
	private static AttackFrame[][] lacerdaDashRightFrames;
	private static AttackFrame[][] lacerdaDashLeftFrames;
	private static AttackFrame[][] lacerdaUpTiltRightFrames;
	private static AttackFrame[][] lacerdaUpTiltLeftFrames;
	private static AttackFrame[][] lacerdaBairRightFrames;
	private static AttackFrame[][] lacerdaBairLeftFrames;
	private static AttackFrame[][] lacerdaFairRightFrames;
	private static AttackFrame[][] lacerdaFairLeftFrames;
	private static AttackFrame[][] lacerdaUpAirRightFrames;
	private static AttackFrame[][] lacerdaUpAirLeftFrames;
	private static AttackFrame[][] lacerdaSideSpecial1RightFrames;
	private static AttackFrame[][] lacerdaSideSpecial1LeftFrames;
	private static AttackFrame[][] lacerdaSideSpecial2RightFrames;
	private static AttackFrame[][] lacerdaSideSpecial2LeftFrames;
	private static AttackFrame[][] lacerdaSideSpecial3RightFrames;
	private static AttackFrame[][] lacerdaSideSpecial3LeftFrames;
	private static AttackFrame[][] lacerdaNeutralSpecial1RightFrames;
	private static AttackFrame[][] lacerdaNeutralSpecial1LeftFrames;
	private static AttackFrame[][] lacerdaNeutralSpecial2RightFrames;
	private static AttackFrame[][] lacerdaNeutralSpecial2LeftFrames;
	private static AttackFrame[][] lacerdaUpSpecialRightFrames;
	private static AttackFrame[][] lacerdaUpSpecialLeftFrames;
	
	private static AttackFrame[] obinoParryRightFrames, obinoParryLeftFrames;
	private static AttackFrame[][] obinoWalkingRightFrames;
	private static AttackFrame[][] obinoWalkingLeftFrames;
	private static AttackFrame[][] obinoJabRightFrames;
	private static AttackFrame[][] obinoJabLeftFrames;
	private static AttackFrame[][] obinoStandingRightFrames;
	private static AttackFrame[][] obinoStandingLeftFrames;
	private static AttackFrame[][] obinoShieldingRightFrames;
	private static AttackFrame[][] obinoShieldHitRightFrames;
	private static AttackFrame[][] obinoShieldingLeftFrames;
	private static AttackFrame[][] obinoShieldHitLeftFrames;
	private static AttackFrame[][] obinoDashRightFrames;
	private static AttackFrame[][] obinoDashLeftFrames;
	private static AttackFrame[][] obinoUpTiltRightFrames;
	private static AttackFrame[][] obinoUpTiltLeftFrames;
	private static AttackFrame[][] obinoBairRightFrames;
	private static AttackFrame[][] obinoBairLeftFrames;
	private static AttackFrame[][] obinoFairRightFrames;
	private static AttackFrame[][] obinoFairLeftFrames;
	private static AttackFrame[][] obinoUpAirRightFrames;
	private static AttackFrame[][] obinoUpAirLeftFrames;
	private static AttackFrame[][] obinoSideSpecialRightFrames;
	private static AttackFrame[][] obinoSideSpecialLeftFrames;
	private static AttackFrame[][] obinoNeutralSpecialRightFrames;
	private static AttackFrame[][] obinoNeutralSpecialLeftFrames;
	private static AttackFrame[][] obinoUpSpecialRightFrames;
	private static AttackFrame[][] obinoUpSpecialLeftFrames;
	
	
	private static Collisionbox brunoCollisionbox, carolCollisionbox;
	
	private static int brunoJabDamage = 10;
	private static int brunoDashDamage = 15;
	private static int brunoUpTiltDamage = 12;
	private static int brunoBairDamage = 20;
	private static int brunoFairDamage = 8;
	private static int brunoUpAirDamage = 15;
	
	private static int carolJabDamage = 7;
	private static int carolDashDamage = 15;
	private static int carolUpTiltDamage = 18;
	private static int carolBairDamage = 10;
	private static int carolFairDamage = 5;
	private static int carolTipperFairDamage = 7;
	private static int carolUpAirDamage = 3;
	
	private static int supercarolBairDamage = 15;
	private static int supercarolFairDamage = 7;
	private static int supercarolTipperFairDamage = 11;
	private static int supercarolUpAirDamage = 5;
	
	private static int lacerdaJabDamage = 8;
	private static int lacerdaDashDamage = 12;
	private static int lacerdaUpTiltDamage = 16;
	private static int lacerdaBairDamage = 10;
	private static int lacerdaFairDamage = 8;
	private static int lacerdaUpAirDamage = 12;
	private static int lacerdaUpSpecialDamage = 5;
	private static int lacerdaSideSpecial1Damage = 20;
	private static int lacerdaSideSpecial2Damage = 35;
	private static int lacerdaSideSpecial3Damage = 50;
	
	private static int obinoJabDamage = 15;
	private static int obinoDashDamage = 12;
	private static int obinoTipperDashDamage = 20;
	private static int obinoUpTiltDamage = 23;
	private static int obinoBairDamage = 16;
	private static int obinoFairDamage = 18;
	private static int obinoUpAirDamage = 18;
	
	


	public static void createAttacks1() {
		
		//BRUNO
		
		brunoCollisionbox = new Collisionbox(75, 50, 50, 100);
		
		brunoShieldingHurtbox = new Hurtbox[] {new Hurtbox(100, 100, 80)};
		
		brunoShieldingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0ShieldingRight[0], brunoShieldingHurtbox, null, 200, 200)},
														 {new AttackFrame(1, Assets.bruno1ShieldingRight[0], brunoShieldingHurtbox, null, 200, 200)}};
														 
		
		brunoShieldingRight = new Attack[] {new Attack(brunoShieldingRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
											new Attack(brunoShieldingRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoShieldHitRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0ShieldHitRight[0], brunoShieldingHurtbox, null, 200, 200)},
														  {new AttackFrame(1, Assets.bruno1ShieldHitRight[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		brunoShieldHitRight = new Attack[] {new Attack(brunoShieldHitRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
											new Attack(brunoShieldHitRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoShieldingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0ShieldingLeft[0], brunoShieldingHurtbox, null, 200, 200)},
													    {new AttackFrame(1, Assets.bruno1ShieldingLeft[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		brunoShieldingLeft = new Attack[] {new Attack(brunoShieldingLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(brunoShieldingLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		brunoShieldHitLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0ShieldHitLeft[0], brunoShieldingHurtbox, null, 200, 200)},
														{new AttackFrame(1, Assets.bruno1ShieldHitLeft[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		brunoShieldHitLeft = new Attack[] {new Attack(brunoShieldHitLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(brunoShieldHitLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoParryRightFrames = new AttackFrame[] {new AttackFrame(1, Assets.bruno0ParryRight, null, null, 200, 200),
												   new AttackFrame(1, Assets.bruno1ParryRight, null, null, 200, 200)};
		
		brunoParryLeftFrames = new AttackFrame[] {new AttackFrame(1, Assets.bruno0ParryLeft, null, null, 200, 200),
				   								   new AttackFrame(1, Assets.bruno1ParryLeft, null, null, 200, 200)};
		
		brunoStandingRightHurtboxes = new Hurtbox[] {new Hurtbox(67, 191, 12),
													 new Hurtbox(116, 191, 12),
													 new Hurtbox(70, 170, 12),
													 new Hurtbox(116, 170, 12),
													 new Hurtbox(87, 150, 18),
													 new Hurtbox(110, 150, 15),
													 new Hurtbox(87, 130, 15),
													 new Hurtbox(110, 130, 15),
													 new Hurtbox(80, 100, 27),
													 new Hurtbox(110, 105, 12),
													 new Hurtbox(110, 83, 12),
													 new Hurtbox(128, 105, 9),
													 new Hurtbox(144, 105, 9),
											 		 new Hurtbox(100, 40, 30),
													 new Hurtbox(100, 75, 9)};
		
		brunoStandingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
														{new AttackFrame(1, Assets.bruno1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
		
		brunoStandingRight = new Attack[] {new Attack(brunoStandingRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(brunoStandingRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoStandingLeftHurtboxes = new Hurtbox[] {new Hurtbox(133, 191, 12),
												    new Hurtbox(84, 191, 12),
												    new Hurtbox(130, 170, 12),
												    new Hurtbox(84, 170, 12),
												    new Hurtbox(113, 150, 18),
												    new Hurtbox(91, 150, 15),
												    new Hurtbox(113, 130, 15),
												    new Hurtbox(90, 130, 15),
												    new Hurtbox(120, 100, 27),
												    new Hurtbox(90, 105, 12),
											        new Hurtbox(90, 83, 12),
												    new Hurtbox(72, 105, 9),
												    new Hurtbox(56, 105, 9),
												    new Hurtbox(100, 40, 30),
												    new Hurtbox(100, 75, 9)};
		
		brunoStandingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
													   {new AttackFrame(1, Assets.bruno1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		brunoStandingLeft = new Attack[] {new Attack(brunoStandingLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										  new Attack(brunoStandingLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoWalkingRightHurtboxes0 = new Hurtbox[] {new Hurtbox(80, 191, 12),
													 new Hurtbox(100, 191, 12),
													 new Hurtbox(85, 170, 12),
													 new Hurtbox(105, 170, 12),
													 new Hurtbox(87, 150, 18),
													 new Hurtbox(110, 150, 15),
													 new Hurtbox(87, 130, 15),
													 new Hurtbox(110, 130, 15),
													 new Hurtbox(80, 100, 27),
													 new Hurtbox(110, 105, 12),
													 new Hurtbox(110, 83, 12),
													 new Hurtbox(128, 105, 9),
													 new Hurtbox(144, 105, 9),
											 		 new Hurtbox(100, 40, 30),
													 new Hurtbox(100, 75, 9)};
		
		brunoWalkingRightHurtboxes1 = new Hurtbox[] {new Hurtbox(75, 191, 12),
													 new Hurtbox(120, 191, 12),
													 new Hurtbox(75, 170, 12),
													 new Hurtbox(116, 170, 12),
													 new Hurtbox(90, 150, 18),
													 new Hurtbox(110, 150, 15),
													 new Hurtbox(90, 130, 15),
													 new Hurtbox(110, 130, 15),
													 new Hurtbox(85, 100, 27),
													 new Hurtbox(110, 105, 12),
													 new Hurtbox(110, 83, 12),
													 new Hurtbox(128, 105, 9),
													 new Hurtbox(144, 105, 9),
											 		 new Hurtbox(100, 40, 30),
													 new Hurtbox(100, 75, 9)};
		
		brunoWalkingRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.bruno0WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(4, Assets.bruno0WalkingRight[1], brunoWalkingRightHurtboxes1, null, 200, 200),
													    new AttackFrame(4, Assets.bruno0WalkingRight[2], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(4, Assets.bruno0WalkingRight[3], brunoStandingRightHurtboxes, null, 200, 200)},
													
													   {new AttackFrame(4, Assets.bruno1WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(4, Assets.bruno1WalkingRight[1], brunoWalkingRightHurtboxes1, null, 200, 200),
												        new AttackFrame(4, Assets.bruno1WalkingRight[2], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(4, Assets.bruno1WalkingRight[3], brunoStandingRightHurtboxes, null, 200, 200)}};
		
		brunoWalkingRight = new Attack[] {new Attack(brunoWalkingRightFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
										  new Attack(brunoWalkingRightFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoWalkingLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(120, 191, 12),
													new Hurtbox(100, 191, 12),
												    new Hurtbox(115, 170, 12),
													new Hurtbox(95, 170, 12),
												    new Hurtbox(113, 150, 18),
												    new Hurtbox(91, 150, 15),
												    new Hurtbox(113, 130, 15),
												    new Hurtbox(90, 130, 15),
												    new Hurtbox(120, 100, 27),
												    new Hurtbox(90, 105, 12),
											        new Hurtbox(90, 83, 12),
												    new Hurtbox(72, 105, 9),
												    new Hurtbox(56, 105, 9),
												    new Hurtbox(100, 40, 30),
												    new Hurtbox(100, 75, 9)};
		
		brunoWalkingLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(125, 191, 12),
													new Hurtbox(80, 191, 12),
													new Hurtbox(125, 170, 12),
													new Hurtbox(84, 170, 12),
													new Hurtbox(110, 150, 18),
													new Hurtbox(90, 150, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(90, 130, 15),
													new Hurtbox(115, 100, 27),
													new Hurtbox(90, 105, 12),
													new Hurtbox(90, 83, 12),
													new Hurtbox(72, 105, 9),
													new Hurtbox(56, 105, 9),
											 		new Hurtbox(100, 40, 30),
													new Hurtbox(100, 75, 9)};
		
		brunoWalkingLeftFrames = new AttackFrame[][] {{new AttackFrame(5, Assets.bruno0WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200),
													   new AttackFrame(5, Assets.bruno0WalkingLeft[1], brunoWalkingLeftHurtboxes1, null, 200, 200),
													   new AttackFrame(5, Assets.bruno0WalkingLeft[2], brunoWalkingLeftHurtboxes0, null, 200, 200),
													   new AttackFrame(5, Assets.bruno0WalkingLeft[3], brunoStandingLeftHurtboxes, null, 200, 200)},
			
													   {new AttackFrame(5, Assets.bruno1WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200),
													    new AttackFrame(5, Assets.bruno1WalkingLeft[1], brunoWalkingLeftHurtboxes1, null, 200, 200),
														new AttackFrame(5, Assets.bruno1WalkingLeft[2], brunoWalkingLeftHurtboxes0, null, 200, 200),
														new AttackFrame(5, Assets.bruno1WalkingLeft[3], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		brunoWalkingLeft = new Attack[] {new Attack(brunoWalkingLeftFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
										 new Attack(brunoWalkingLeftFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoJabRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												 new Hurtbox(116, 191, 12),
												 new Hurtbox(70, 170, 12),
												 new Hurtbox(116, 170, 12),
											     new Hurtbox(87, 150, 18),
											     new Hurtbox(110, 150, 15),
											     new Hurtbox(87, 130, 15),
											     new Hurtbox(110, 130, 15),
											     new Hurtbox(85, 107, 18),
											     new Hurtbox(85, 79, 15),
											     new Hurtbox(62, 92, 20),
											     new Hurtbox(110, 105, 12),
											     new Hurtbox(110, 83, 12),
											     new Hurtbox(128, 105, 9),
											     new Hurtbox(144, 105, 9),
											     new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		brunoJabRightHurtboxes1 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												 new Hurtbox(116, 191, 12),
												 new Hurtbox(70, 170, 12),
												 new Hurtbox(116, 170, 12),
											     new Hurtbox(87, 150, 18),
											     new Hurtbox(110, 150, 15),
											     new Hurtbox(87, 130, 15),
											     new Hurtbox(110, 130, 15),
											     new Hurtbox(85, 107, 18),
											     new Hurtbox(80, 85, 17),
											     new Hurtbox(110, 105, 12),
											     new Hurtbox(110, 83, 12),
											     new Hurtbox(128, 105, 9),
											     new Hurtbox(144, 105, 9),
											     new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		brunoJabRightHurtboxes2 = new Hurtbox[] {new Hurtbox(90, 191, 12),
												 new Hurtbox(116, 191, 12),
												 new Hurtbox(92, 172, 12),
												 new Hurtbox(116, 170, 12),
											     new Hurtbox(92, 150, 18),
											     new Hurtbox(110, 150, 15),
											     new Hurtbox(92, 130, 15),
											     new Hurtbox(110, 130, 15),
											     new Hurtbox(90, 107, 18),
											     new Hurtbox(90, 85, 17),
											     new Hurtbox(110, 105, 12),
											     new Hurtbox(110, 83, 12),
											     new Hurtbox(128, 94, 9),
											     new Hurtbox(144, 94, 9),
											     new Hurtbox(160, 94, 9),
											     new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		brunoJabRightHurtboxes3 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												 new Hurtbox(116, 191, 12),
												 new Hurtbox(70, 170, 12),
												 new Hurtbox(116, 170, 12),
											     new Hurtbox(87, 150, 18),
											     new Hurtbox(110, 150, 15),
											     new Hurtbox(87, 130, 15),
											     new Hurtbox(110, 130, 15),
											     new Hurtbox(85, 107, 18),
											     new Hurtbox(80, 85, 17),
											     new Hurtbox(110, 105, 12),
											     new Hurtbox(110, 83, 12),
											     new Hurtbox(128, 100, 9),
											     new Hurtbox(135, 110, 9),
											     new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		brunoJabRightHitboxes = new Hitbox[] {new Hitbox(160, 95, 15),
											  new Hitbox(135, 95, 15)};
		
		brunoJabRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0JabRight[0], brunoJabRightHurtboxes0, null, 200, 200),
												    new AttackFrame(1, Assets.bruno0JabRight[1], brunoJabRightHurtboxes1, null, 200, 200),
												    new AttackFrame(5, Assets.bruno0JabRight[2], brunoJabRightHurtboxes2, brunoJabRightHitboxes, 200, 200),
												    new AttackFrame(8, Assets.bruno0JabRight[2], brunoJabRightHurtboxes2, null, 200, 200),
												    new AttackFrame(5, Assets.bruno0JabRight[3], brunoJabRightHurtboxes3, null, 200, 200)},
													
												   {new AttackFrame(1, Assets.bruno1JabRight[0], brunoJabRightHurtboxes0, null, 200, 200),
													new AttackFrame(1, Assets.bruno1JabRight[1], brunoJabRightHurtboxes1, null, 200, 200),
													new AttackFrame(5, Assets.bruno1JabRight[2], brunoJabRightHurtboxes2, brunoJabRightHitboxes, 200, 200),
													new AttackFrame(8, Assets.bruno1JabRight[2], brunoJabRightHurtboxes2, null, 200, 200),
													new AttackFrame(5, Assets.bruno1JabRight[3], brunoJabRightHurtboxes3, null, 200, 200)}};
		
		brunoJabRight = new Attack[] {new Attack(brunoJabRightFrames[0], 5, brunoJabDamage, 5, -10, 7, 20, brunoCollisionbox),
									  new Attack(brunoJabRightFrames[1], 5, brunoJabDamage, 5, -10, 7, 20, brunoCollisionbox)};
		
		
		brunoJabLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
											    new Hurtbox(84, 191, 12),
											    new Hurtbox(130, 170, 12),
											    new Hurtbox(84, 170, 12),
											    new Hurtbox(87, 150, 18),
											    new Hurtbox(110, 150, 15),
											    new Hurtbox(87, 130, 15),
											    new Hurtbox(110, 130, 15),
											    new Hurtbox(85, 107, 18),
											    new Hurtbox(85, 79, 15),
											    new Hurtbox(138, 92, 20),
											    new Hurtbox(110, 105, 12),
											    new Hurtbox(110, 83, 12),
											    new Hurtbox(62, 105, 9),
											    new Hurtbox(56, 105, 9),
											    new Hurtbox(100, 40, 30),
											    new Hurtbox(100, 75, 9)};

		brunoJabLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(133, 191, 12),
											    new Hurtbox(84, 191, 12),
											    new Hurtbox(130, 170, 12),
											    new Hurtbox(84, 170, 12),
											    new Hurtbox(113, 150, 18),
											    new Hurtbox(90, 150, 15),
											    new Hurtbox(113, 130, 15),
											    new Hurtbox(90, 130, 15),
											    new Hurtbox(115, 107, 18),
											    new Hurtbox(120, 85, 17),
											    new Hurtbox(90, 105, 12),
											    new Hurtbox(90, 83, 12),
											    new Hurtbox(72, 105, 9),
											    new Hurtbox(56, 105, 9),
											    new Hurtbox(100, 40, 30),
											    new Hurtbox(100, 75, 9)};

		brunoJabLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(110, 191, 12),
												new Hurtbox(84, 191, 12),
											    new Hurtbox(108, 172, 12),
										    	new Hurtbox(84, 170, 12),
											    new Hurtbox(108, 150, 18),
											    new Hurtbox(90, 150, 15),
											    new Hurtbox(108, 130, 15),
											    new Hurtbox(90, 130, 15),
											    new Hurtbox(110, 107, 18),
											    new Hurtbox(110, 85, 17),
											    new Hurtbox(90, 105, 12),
											    new Hurtbox(90, 83, 12),
											    new Hurtbox(72, 94, 9),
											    new Hurtbox(56, 94, 9),
											    new Hurtbox(40, 94, 9),
											    new Hurtbox(100, 40, 30),
										        new Hurtbox(100, 75, 9)};

		brunoJabLeftHurtboxes3 = new Hurtbox[] {new Hurtbox(133, 191, 12),
											    new Hurtbox(84, 191, 12),
											    new Hurtbox(130, 170, 12),
											    new Hurtbox(84, 170, 12),
											    new Hurtbox(113, 150, 18),
											    new Hurtbox(90, 150, 15),
										        new Hurtbox(113, 130, 15),
										        new Hurtbox(90, 130, 15),
									    	    new Hurtbox(115, 107, 18),
								     		    new Hurtbox(120, 85, 17),
						      			        new Hurtbox(90, 105, 12),
										        new Hurtbox(90, 83, 12),
										        new Hurtbox(72, 100, 9),
									            new Hurtbox(65, 110, 9),
										        new Hurtbox(100, 40, 30),
										        new Hurtbox(100, 75, 9)};
		
		brunoJabLeftHitboxes = new Hitbox[] {new Hitbox(40, 95, 15),
											 new Hitbox(65, 95, 15)};
		
		brunoJabLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0JabLeft[0], brunoJabLeftHurtboxes0, null, 200, 200),
												   new AttackFrame(1, Assets.bruno0JabLeft[1], brunoJabLeftHurtboxes1, null, 200, 200),
												   new AttackFrame(5, Assets.bruno0JabLeft[2], brunoJabLeftHurtboxes2, brunoJabLeftHitboxes, 200, 200),
												   new AttackFrame(8, Assets.bruno0JabLeft[2], brunoJabLeftHurtboxes2, null, 200, 200),
												   new AttackFrame(5, Assets.bruno0JabLeft[3], brunoJabLeftHurtboxes3, null, 200, 200)},
			
												  {new AttackFrame(1, Assets.bruno1JabLeft[0], brunoJabLeftHurtboxes0, null, 200, 200),
												   new AttackFrame(1, Assets.bruno1JabLeft[1], brunoJabLeftHurtboxes1, null, 200, 200),
												   new AttackFrame(5, Assets.bruno1JabLeft[2], brunoJabLeftHurtboxes2, brunoJabLeftHitboxes, 200, 200),
												   new AttackFrame(8, Assets.bruno1JabLeft[2], brunoJabLeftHurtboxes2, null, 200, 200),
												   new AttackFrame(5, Assets.bruno1JabLeft[3], brunoJabLeftHurtboxes3, null, 200, 200)}};
		
		brunoJabLeft = new Attack[] {new Attack(brunoJabLeftFrames[0], 5, brunoJabDamage, -5, -10, 7, 20, brunoCollisionbox),
									 new Attack(brunoJabLeftFrames[1], 5, brunoJabDamage, -5, -10, 7, 20, brunoCollisionbox)};
		
		
		brunoDashRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												  new Hurtbox(116, 191, 12),
												  new Hurtbox(70, 170, 12),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(87, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(87, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(85, 105, 17),
												  new Hurtbox(85, 82, 12),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(115, 83, 14),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		brunoDashRightHurtboxes1 = new Hurtbox[] {new Hurtbox(80, 191, 12),
												  new Hurtbox(100, 191, 12),
												  new Hurtbox(85, 170, 12),
												  new Hurtbox(105, 170, 12),
												  new Hurtbox(87, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(87, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(85, 105, 17),
												  new Hurtbox(85, 82, 12),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		brunoDashRightHurtboxes2 = new Hurtbox[] {new Hurtbox(75, 191, 12),
												  new Hurtbox(120, 191, 12),
												  new Hurtbox(75, 170, 12),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(90, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(90, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(85, 105, 17),
												  new Hurtbox(85, 82, 12),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9),
												  new Hurtbox(120, 70, 12)};
		
		brunoDashRightHurtboxes3 = new Hurtbox[] {new Hurtbox(75, 191, 12),
												  new Hurtbox(120, 191, 12),
												  new Hurtbox(75, 170, 12),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(90, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(90, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(85, 105, 17),
												  new Hurtbox(85, 82, 12),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9),
												  new Hurtbox(125, 100, 12)};
		
		brunoDashRightHurtboxes4 = new Hurtbox[] {new Hurtbox(75, 191, 12),
												  new Hurtbox(120, 191, 12),
												  new Hurtbox(75, 170, 12),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(90, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(90, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(85, 105, 17),
												  new Hurtbox(85, 82, 12),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9),
												  new Hurtbox(125, 120, 12)};
		
		brunoDashRightHitboxes0 = new Hitbox[] {new Hitbox(145, 45, 17),
												new Hitbox(165, 25, 30)};
		
		brunoDashRightHitboxes1 = new Hitbox[] {new Hitbox(155, 100, 17),
												new Hitbox(185, 100, 30)};
		
		brunoDashRightHitboxes2 = new Hitbox[] {new Hitbox(145, 140, 17),
												new Hitbox(165, 165, 30)};
		
		brunoDashRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.bruno0DashRight[0], brunoDashRightHurtboxes0, null, 200, 200),
												     new AttackFrame(4, Assets.bruno0DashRight[1], brunoDashRightHurtboxes1, null, 200, 200),
												     new AttackFrame(3, Assets.bruno0DashRight[2], brunoDashRightHurtboxes2, brunoDashRightHitboxes0, 200, 200),
												     new AttackFrame(3, Assets.bruno0DashRight[3], brunoDashRightHurtboxes3, brunoDashRightHitboxes1, 200, 200),
												     new AttackFrame(3, Assets.bruno0DashRight[4], brunoDashRightHurtboxes4, brunoDashRightHitboxes2, 200, 200),
												     new AttackFrame(10, Assets.bruno0DashRight[4], brunoDashRightHurtboxes4, null, 200, 200),
												     new AttackFrame(10, Assets.bruno0WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200)},
			
													{new AttackFrame(1, Assets.bruno1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.bruno1DashRight[0], brunoDashRightHurtboxes0, null, 200, 200),
												     new AttackFrame(4, Assets.bruno1DashRight[1], brunoDashRightHurtboxes1, null, 200, 200),
												     new AttackFrame(3, Assets.bruno1DashRight[2], brunoDashRightHurtboxes2, brunoDashRightHitboxes0, 200, 200),
												     new AttackFrame(3, Assets.bruno1DashRight[3], brunoDashRightHurtboxes3, brunoDashRightHitboxes1, 200, 200),
												     new AttackFrame(3, Assets.bruno1DashRight[4], brunoDashRightHurtboxes4, brunoDashRightHitboxes2, 200, 200),
												     new AttackFrame(10, Assets.bruno1DashRight[4], brunoDashRightHurtboxes4, null, 200, 200),
												     new AttackFrame(10, Assets.bruno1WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200)}};
		
		brunoDashRight = new Attack[] {new Attack(brunoDashRightFrames[0], 8, brunoDashDamage, 20, -10, 7, 20, brunoCollisionbox),
									   new Attack(brunoDashRightFrames[1], 8, brunoDashDamage, 20, -10, 7, 20, brunoCollisionbox)};
		
		
		brunoDashLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												 new Hurtbox(84, 191, 12),
												 new Hurtbox(130, 170, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(113, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(115, 105, 17),
												 new Hurtbox(115, 82, 12),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(85, 83, 14),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9)};
		
		brunoDashLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(120, 191, 12),
												 new Hurtbox(100, 191, 12),
												 new Hurtbox(115, 170, 12),
												 new Hurtbox(95, 170, 12),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(113, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(115, 105, 17),
												 new Hurtbox(115, 82, 12),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9)};
		
		brunoDashLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(125, 191, 12),
												 new Hurtbox(80, 191, 12),
												 new Hurtbox(125, 170, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(110, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(110, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(115, 105, 17),
												 new Hurtbox(115, 82, 12),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9),
												 new Hurtbox(80, 70, 12)};
		
		brunoDashLeftHurtboxes3 = new Hurtbox[] {new Hurtbox(125, 191, 12),
												 new Hurtbox(80, 191, 12),
												 new Hurtbox(125, 170, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(110, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(110, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(115, 105, 17),
												 new Hurtbox(115, 82, 12),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9),
												 new Hurtbox(75, 100, 12)};
		
		brunoDashLeftHurtboxes4 = new Hurtbox[] {new Hurtbox(125, 191, 12),
												 new Hurtbox(80, 191, 12),
												 new Hurtbox(125, 170, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(110, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(110, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(115, 105, 17),
												 new Hurtbox(115, 82, 12),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9),
												 new Hurtbox(75, 120, 12)};
		
		brunoDashLeftHitboxes0 = new Hitbox[] {new Hitbox(55, 45, 17),
											   new Hitbox(35, 25, 30)};
		
		brunoDashLeftHitboxes1 = new Hitbox[] {new Hitbox(45, 100, 17),
											   new Hitbox(15, 100, 30)};
		
		brunoDashLeftHitboxes2 = new Hitbox[] {new Hitbox(55, 140, 17),
											   new Hitbox(35, 165, 30)};
		
		brunoDashLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
												    new AttackFrame(3, Assets.bruno0DashLeft[0], brunoDashLeftHurtboxes0, null, 200, 200),
												    new AttackFrame(4, Assets.bruno0DashLeft[1], brunoDashLeftHurtboxes1, null, 200, 200),
												    new AttackFrame(3, Assets.bruno0DashLeft[2], brunoDashLeftHurtboxes2, brunoDashLeftHitboxes0, 200, 200),
												    new AttackFrame(3, Assets.bruno0DashLeft[3], brunoDashLeftHurtboxes3, brunoDashLeftHitboxes1, 200, 200),
												    new AttackFrame(3, Assets.bruno0DashLeft[4], brunoDashLeftHurtboxes4, brunoDashLeftHitboxes2, 200, 200),
												    new AttackFrame(10, Assets.bruno0DashLeft[4], brunoDashLeftHurtboxes4, null, 200, 200),
												    new AttackFrame(10, Assets.bruno0WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200)},
			
												   {new AttackFrame(1, Assets.bruno1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
												    new AttackFrame(3, Assets.bruno1DashLeft[0], brunoDashLeftHurtboxes0, null, 200, 200),
												    new AttackFrame(4, Assets.bruno1DashLeft[1], brunoDashLeftHurtboxes1, null, 200, 200),
												    new AttackFrame(3, Assets.bruno1DashLeft[2], brunoDashLeftHurtboxes2, brunoDashLeftHitboxes0, 200, 200),
												    new AttackFrame(3, Assets.bruno1DashLeft[3], brunoDashLeftHurtboxes3, brunoDashLeftHitboxes1, 200, 200),
												    new AttackFrame(3, Assets.bruno1DashLeft[4], brunoDashLeftHurtboxes4, brunoDashLeftHitboxes2, 200, 200),
												    new AttackFrame(10, Assets.bruno1DashLeft[4], brunoDashLeftHurtboxes4, null, 200, 200),
												    new AttackFrame(10, Assets.bruno1WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200)}};
		
		brunoDashLeft = new Attack[] {new Attack(brunoDashLeftFrames[0], 8, brunoDashDamage, -20, -10, 7, 20, brunoCollisionbox),
									  new Attack(brunoDashLeftFrames[1], 8, brunoDashDamage, -20, -10, 7, 20, brunoCollisionbox)};
		
		
		brunoUpTiltRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													new Hurtbox(116, 191, 12),
													new Hurtbox(70, 170, 12),
													new Hurtbox(116, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(90, 107, 18),
												    new Hurtbox(90, 85, 17),
													new Hurtbox(110, 105, 12),
													new Hurtbox(110, 83, 12),
													new Hurtbox(124, 105, 9),
													new Hurtbox(140, 105, 9),
											 		new Hurtbox(100, 40, 30),
													new Hurtbox(100, 75, 9)};
		
		brunoUpTiltRightHurtboxes1 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													new Hurtbox(116, 191, 12),
													new Hurtbox(70, 170, 12),
													new Hurtbox(116, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(90, 107, 18),
												    new Hurtbox(90, 85, 17),
													new Hurtbox(110, 105, 12),
													new Hurtbox(110, 83, 12),
													new Hurtbox(124, 105, 9),
													new Hurtbox(140, 105, 9),
											 		new Hurtbox(100, 40, 32),
													new Hurtbox(100, 75, 9)};
		
		brunoUpTiltRightHurtboxes2 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													new Hurtbox(116, 191, 12),
													new Hurtbox(70, 170, 12),
													new Hurtbox(116, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(90, 107, 18),
												    new Hurtbox(90, 85, 17),
													new Hurtbox(110, 105, 12),
													new Hurtbox(110, 83, 12),
													new Hurtbox(124, 105, 9),
													new Hurtbox(140, 105, 9),
											 		new Hurtbox(100, 40, 30),
													new Hurtbox(100, 75, 9)};
		
		brunoUpTiltRightHurtboxes3 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													new Hurtbox(116, 191, 12),
													new Hurtbox(70, 170, 12),
													new Hurtbox(116, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(90, 107, 18),
												    new Hurtbox(90, 85, 17),
													new Hurtbox(110, 105, 12),
													new Hurtbox(110, 83, 12),
													new Hurtbox(124, 105, 9),
													new Hurtbox(140, 105, 9),
											 		new Hurtbox(100, 40, 30),
													new Hurtbox(100, 75, 9),
													new Hurtbox(70, 70, 10),
													new Hurtbox(65, 50, 10)};
		
		
		brunoUpTiltRightHitboxes0 = new Hitbox[] {new Hitbox(140, 40, 17),
												  new Hitbox(160, 20, 30)};
		
		brunoUpTiltRightHitboxes1 = new Hitbox[] {new Hitbox(100, -15, 17),
				  								  new Hitbox(100, -47, 30)};
		
		brunoUpTiltRightHitboxes2 = new Hitbox[] {new Hitbox(37, 20, 17),
				  								  new Hitbox(17, 0, 30)};
		
		
		brunoUpTiltRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(6, Assets.bruno0UpTiltRight[0], brunoUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.bruno0UpTiltRight[1], brunoUpTiltRightHurtboxes1, brunoUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.bruno0UpTiltRight[2], brunoUpTiltRightHurtboxes2, brunoUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.bruno0UpTiltRight[3], brunoUpTiltRightHurtboxes3, brunoUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.bruno0UpTiltRight[3], brunoUpTiltRightHurtboxes3, null, 200, 400, 0, -200),
													   new AttackFrame(4, Assets.bruno0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
			
													  {new AttackFrame(1, Assets.bruno1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(6, Assets.bruno1UpTiltRight[0], brunoUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.bruno1UpTiltRight[1], brunoUpTiltRightHurtboxes1, brunoUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.bruno1UpTiltRight[2], brunoUpTiltRightHurtboxes2, brunoUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.bruno1UpTiltRight[3], brunoUpTiltRightHurtboxes3, brunoUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.bruno1UpTiltRight[3], brunoUpTiltRightHurtboxes3, null, 200, 400, 0, -200),
													   new AttackFrame(4, Assets.bruno1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
		
													   
		brunoUpTiltRight = new Attack[] {new Attack(brunoUpTiltRightFrames[0], 7, brunoUpTiltDamage, -3, -17, 7, 35, brunoCollisionbox, 0, -3),
										 new Attack(brunoUpTiltRightFrames[1], 7, brunoUpTiltDamage, -3, -17, 7, 35, brunoCollisionbox, 0, -3)};
		
		
		brunoUpTiltLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
												   new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(110, 107, 18),
												   new Hurtbox(110, 85, 17),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(76, 105, 9),
												   new Hurtbox(60, 105, 9),
											 	   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		brunoUpTiltLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
												   new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(110, 107, 18),
												   new Hurtbox(110, 85, 17),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(76, 105, 9),
												   new Hurtbox(60, 105, 9),
											 	   new Hurtbox(100, 40, 32),
												   new Hurtbox(100, 75, 9)};
		
		brunoUpTiltLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
												   new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(110, 107, 18),
												   new Hurtbox(110, 85, 17),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(76, 105, 9),
												   new Hurtbox(60, 105, 9),
											 	   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		brunoUpTiltLeftHurtboxes3 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
												   new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(110, 107, 18),
												   new Hurtbox(110, 85, 17),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(76, 105, 9),
												   new Hurtbox(60, 105, 9),
											 	   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(130, 70, 10),
												   new Hurtbox(135, 50, 10)};
		
		
		brunoUpTiltLeftHitboxes0 = new Hitbox[] {new Hitbox(60, 40, 17),
				  								 new Hitbox(40, 20, 30)};
		
		brunoUpTiltLeftHitboxes1 = new Hitbox[] {new Hitbox(100, -15, 17),
				  								 new Hitbox(100, -47, 30)};
		
		brunoUpTiltLeftHitboxes2 = new Hitbox[] {new Hitbox(163, 20, 17),
				  								 new Hitbox(183, 0, 30)};
		
		
		brunoUpTiltLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.bruno0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(6, Assets.bruno0UpTiltLeft[0], brunoUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.bruno0UpTiltLeft[1], brunoUpTiltLeftHurtboxes1, brunoUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.bruno0UpTiltLeft[2], brunoUpTiltLeftHurtboxes2, brunoUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.bruno0UpTiltLeft[3], brunoUpTiltLeftHurtboxes3, brunoUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.bruno0UpTiltLeft[3], brunoUpTiltLeftHurtboxes3, null, 200, 400, 0, -200),
													  new AttackFrame(4, Assets.bruno0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
			
													 {new AttackFrame(1, Assets.bruno1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(6, Assets.bruno1UpTiltLeft[0], brunoUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.bruno1UpTiltLeft[1], brunoUpTiltLeftHurtboxes1, brunoUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.bruno1UpTiltLeft[2], brunoUpTiltLeftHurtboxes2, brunoUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.bruno1UpTiltLeft[3], brunoUpTiltLeftHurtboxes3, brunoUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.bruno1UpTiltLeft[3], brunoUpTiltLeftHurtboxes3, null, 200, 400, 0, -200),
													  new AttackFrame(4, Assets.bruno1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
													   
		brunoUpTiltLeft = new Attack[] {new Attack(brunoUpTiltLeftFrames[0], 7, brunoUpTiltDamage, 3, -17, 7, 35, brunoCollisionbox, 0, -3),
										 new Attack(brunoUpTiltLeftFrames[1], 7, brunoUpTiltDamage, 3, -17, 7, 35, brunoCollisionbox, 0, -3)};
		
		
		
		brunoBairRightHurtboxes0 = new Hurtbox[] {new Hurtbox(116, 191, 12),
												  new Hurtbox(95, 170, 12),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(87, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(87, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(80, 100, 27),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
												  new Hurtbox(128, 105, 9),
												  new Hurtbox(144, 105, 9),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		brunoBairRightHurtboxes1 = new Hurtbox[] {new Hurtbox(116, 191, 12),
												  new Hurtbox(60, 160, 12),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(87, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(87, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(80, 100, 27),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
												  new Hurtbox(128, 105, 9),
												  new Hurtbox(144, 105, 9),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		brunoBairRightHurtboxes2 = new Hurtbox[] {new Hurtbox(116, 191, 15),
												  new Hurtbox(60, 145, 15),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(82, 140, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(87, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(80, 100, 27),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
												  new Hurtbox(128, 105, 9),
												  new Hurtbox(144, 105, 9),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		
		brunoBairRightHitboxes = new Hitbox[] {new Hitbox(60, 147, 17),
											   new Hitbox(40, 147, 17),
											   new Hitbox(10, 147, 23)};
		
		
		brunoBairRightFrames = new AttackFrame[][] {{new AttackFrame(10, Assets.bruno0BairRight[0], brunoBairRightHurtboxes0, null, 200, 200),
													 new AttackFrame(3, Assets.bruno0BairRight[1], brunoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(3, Assets.bruno0BairRight[2], brunoBairRightHurtboxes2, brunoBairRightHitboxes, 200, 200),
													 new AttackFrame(10, Assets.bruno0BairRight[2], brunoBairRightHurtboxes2, null, 200, 200),
													 new AttackFrame(10, Assets.bruno0BairRight[1], brunoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(7, Assets.bruno0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
			
													{new AttackFrame(10, Assets.bruno1BairRight[0], brunoBairRightHurtboxes0, null, 200, 200),
												     new AttackFrame(3, Assets.bruno1BairRight[1], brunoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(3, Assets.bruno1BairRight[2], brunoBairRightHurtboxes2, brunoBairRightHitboxes, 200, 200),
													 new AttackFrame(10, Assets.bruno1BairRight[2], brunoBairRightHurtboxes2, null, 200, 200),
													 new AttackFrame(10, Assets.bruno1BairRight[1], brunoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(7, Assets.bruno1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
													 
		
		brunoBairRight = new Attack[] {new Attack(brunoBairRightFrames[0], 6, brunoBairDamage, -20, -15, 7, 30, brunoCollisionbox),
									   new Attack(brunoBairRightFrames[1], 6, brunoBairDamage, -20, -15, 7, 30, brunoCollisionbox)};
		
		
		brunoBairLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(84, 191, 12),
												 new Hurtbox(105, 170, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(113, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(120, 100, 27),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
												 new Hurtbox(72, 105, 9),
												 new Hurtbox(56, 105, 9),
										 		 new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		brunoBairLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(84, 191, 12),
				  								 new Hurtbox(140, 160, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(113, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(120, 100, 27),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
												 new Hurtbox(72, 105, 9),
												 new Hurtbox(56, 105, 9),
										 		 new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		brunoBairLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(84, 191, 15),
												 new Hurtbox(140, 145, 15),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(113, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(120, 100, 27),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
												 new Hurtbox(72, 105, 9),
												 new Hurtbox(56, 105, 9),
										 		 new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		
		brunoBairLeftHitboxes = new Hitbox[] {new Hitbox(140, 147, 17),
											  new Hitbox(160, 147, 17),
											  new Hitbox(190, 147, 23)};
		
		
		brunoBairLeftFrames = new AttackFrame[][] {{new AttackFrame(10, Assets.bruno0BairLeft[0], brunoBairLeftHurtboxes0, null, 200, 200),
													 new AttackFrame(3, Assets.bruno0BairLeft[1], brunoBairLeftHurtboxes1, null, 200, 200),
													 new AttackFrame(3, Assets.bruno0BairLeft[2], brunoBairLeftHurtboxes2, brunoBairLeftHitboxes, 200, 200),
													 new AttackFrame(10, Assets.bruno0BairLeft[2], brunoBairLeftHurtboxes2, null, 200, 200),
													 new AttackFrame(10, Assets.bruno0BairLeft[1], brunoBairLeftHurtboxes1, null, 200, 200),
													 new AttackFrame(7, Assets.bruno0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
			
													{new AttackFrame(10, Assets.bruno1BairLeft[0], brunoBairLeftHurtboxes0, null, 200, 200),
												     new AttackFrame(3, Assets.bruno1BairLeft[1], brunoBairLeftHurtboxes1, null, 200, 200),
													 new AttackFrame(3, Assets.bruno1BairLeft[2], brunoBairLeftHurtboxes2, brunoBairLeftHitboxes, 200, 200),
													 new AttackFrame(10, Assets.bruno1BairLeft[2], brunoBairLeftHurtboxes2, null, 200, 200),
													 new AttackFrame(10, Assets.bruno1BairLeft[1], brunoBairLeftHurtboxes1, null, 200, 200),
													 new AttackFrame(7, Assets.bruno1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
													 
		
		brunoBairLeft = new Attack[] {new Attack(brunoBairLeftFrames[0], 6, brunoBairDamage, 20, -15, 7, 30, brunoCollisionbox),
									   new Attack(brunoBairLeftFrames[1], 6, brunoBairDamage, 20, -15, 7, 30, brunoCollisionbox)};
		
		
		
		
		brunoFairRightHurtboxes = new Hurtbox[] {new Hurtbox(67, 191, 12),
												 new Hurtbox(116, 191, 12),
												 new Hurtbox(70, 170, 12),
												 new Hurtbox(116, 170, 12),
												 new Hurtbox(87, 150, 18),
												 new Hurtbox(110, 150, 15),
												 new Hurtbox(87, 130, 15),
												 new Hurtbox(110, 130, 15),
												 new Hurtbox(85, 105, 17),
												 new Hurtbox(85, 82, 12),
												 new Hurtbox(110, 105, 12),
												 new Hurtbox(115, 83, 14),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9)};
		
		
		
		brunoFairRightHitboxes0 = new Hitbox[] {new Hitbox(140, 135, 17),
												new Hitbox(160, 160, 30)};
		
		brunoFairRightHitboxes1 = new Hitbox[] {new Hitbox(150, 95, 17),
												new Hitbox(185, 95, 30)};
		
		brunoFairRightHitboxes2 = new Hitbox[] {new Hitbox(140, 40, 17),
												new Hitbox(160, 20, 30)};
		
		
		brunoFairRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.bruno0FairRight[0], brunoFairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.bruno0FairRight[1], brunoFairRightHurtboxes, brunoFairRightHitboxes0, 200, 200),
													 new AttackFrame(3, Assets.bruno0FairRight[2], brunoFairRightHurtboxes, brunoFairRightHitboxes1, 200, 200),
													 new AttackFrame(3, Assets.bruno0FairRight[3], brunoFairRightHurtboxes, brunoFairRightHitboxes2, 200, 200),
													 new AttackFrame(10, Assets.bruno0FairRight[4], brunoFairRightHurtboxes, null, 200, 200)},
			
													{new AttackFrame(4, Assets.bruno1FairRight[0], brunoFairRightHurtboxes, null, 200, 200),
												     new AttackFrame(3, Assets.bruno1FairRight[1], brunoFairRightHurtboxes, brunoFairRightHitboxes0, 200, 200),
												     new AttackFrame(3, Assets.bruno1FairRight[2], brunoFairRightHurtboxes, brunoFairRightHitboxes1, 200, 200),
													 new AttackFrame(3, Assets.bruno1FairRight[3], brunoFairRightHurtboxes, brunoFairRightHitboxes2, 200, 200),
													 new AttackFrame(10, Assets.bruno1FairRight[4], brunoFairRightHurtboxes, null, 200, 200)}};
													 
		brunoFairRight = new Attack[] {new Attack(brunoFairRightFrames[0], 5, brunoFairDamage, 5, -15, 7, 30, brunoCollisionbox),
									   new Attack(brunoFairRightFrames[1], 5, brunoFairDamage, 5, -15, 7, 30, brunoCollisionbox)};
		
		
		
		brunoFairLeftHurtboxes = new Hurtbox[] {new Hurtbox(133, 191, 12),
												new Hurtbox(84, 191, 12),
												new Hurtbox(130, 170, 12),
												new Hurtbox(84, 170, 12),
												new Hurtbox(113, 150, 18),
												new Hurtbox(90, 150, 15),
												new Hurtbox(113, 130, 15),
												new Hurtbox(90, 130, 15),
												new Hurtbox(115, 105, 17),
												new Hurtbox(115, 82, 12),
												new Hurtbox(90, 105, 12),
												new Hurtbox(85, 83, 14),
										 		new Hurtbox(100, 40, 30),
												new Hurtbox(100, 75, 9)};

		brunoFairLeftHitboxes0 = new Hitbox[] {new Hitbox(60, 135, 17),
											   new Hitbox(40, 160, 30)};

		brunoFairLeftHitboxes1 = new Hitbox[] {new Hitbox(50, 95, 17),
											   new Hitbox(15, 95, 30)};

		brunoFairLeftHitboxes2 = new Hitbox[] {new Hitbox(60, 40, 17),
											   new Hitbox(40, 20, 30)};


		brunoFairLeftFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.bruno0FairLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.bruno0FairLeft[1], brunoFairLeftHurtboxes, brunoFairLeftHitboxes0, 200, 200),
													 new AttackFrame(3, Assets.bruno0FairLeft[2], brunoFairLeftHurtboxes, brunoFairLeftHitboxes1, 200, 200),
													 new AttackFrame(3, Assets.bruno0FairLeft[3], brunoFairLeftHurtboxes, brunoFairLeftHitboxes2, 200, 200),
													 new AttackFrame(10, Assets.bruno0FairLeft[4], brunoFairLeftHurtboxes, null, 200, 200)},
								
													{new AttackFrame(4, Assets.bruno1FairLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
												     new AttackFrame(3, Assets.bruno1FairLeft[1], brunoFairLeftHurtboxes, brunoFairLeftHitboxes0, 200, 200),
												     new AttackFrame(3, Assets.bruno1FairLeft[2], brunoFairLeftHurtboxes, brunoFairLeftHitboxes1, 200, 200),
													 new AttackFrame(3, Assets.bruno1FairLeft[3], brunoFairLeftHurtboxes, brunoFairLeftHitboxes2, 200, 200),
													 new AttackFrame(10, Assets.bruno1FairLeft[4], brunoFairLeftHurtboxes, null, 200, 200)}};
					 
		brunoFairLeft = new Attack[] {new Attack(brunoFairLeftFrames[0], 5, brunoFairDamage, -5, -15, 7, 30, brunoCollisionbox),
									   new Attack(brunoFairLeftFrames[1], 5, brunoFairDamage, -5, -15, 7, 30, brunoCollisionbox)};
		
		
		
		brunoUpAirRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												   new Hurtbox(116, 191, 12),
											       new Hurtbox(70, 170, 12),
												   new Hurtbox(116, 170, 12),
												   new Hurtbox(87, 150, 18),
												   new Hurtbox(110, 150, 15),
												   new Hurtbox(87, 130, 15),
												   new Hurtbox(110, 130, 15),
												   new Hurtbox(80, 100, 27),
												   new Hurtbox(110, 105, 12),
												   new Hurtbox(110, 83, 12),
											 	   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		brunoUpAirRightHurtboxes1 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												   new Hurtbox(116, 191, 12),
												   new Hurtbox(70, 170, 12),
												   new Hurtbox(116, 170, 12),
												   new Hurtbox(87, 150, 18),
												   new Hurtbox(110, 150, 15),
												   new Hurtbox(87, 130, 15),
												   new Hurtbox(110, 130, 15),
												   new Hurtbox(85, 105, 17),
												   new Hurtbox(85, 82, 12),
												   new Hurtbox(110, 105, 12),
												   new Hurtbox(115, 83, 14),
										 		   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		

		
		brunoUpAirRightHitboxes = new Hitbox[] {new Hitbox(105, 0, 25),
											    new Hitbox(105, -30, 20),
											    new Hitbox(105, -60, 20),
											    new Hitbox(105, -90, 20)};
		
		brunoUpAirRightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.bruno0UpAirRight[0], brunoUpAirRightHurtboxes0, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.bruno0UpAirRight[1], brunoUpAirRightHurtboxes1, null, 200, 400, 0, -200),
													  new AttackFrame(6, Assets.bruno0UpAirRight[2], brunoUpAirRightHurtboxes1, brunoUpAirRightHitboxes, 200, 400, 0, -200),
													  new AttackFrame(4, Assets.bruno0UpAirRight[2], brunoUpAirRightHurtboxes1, null, 200, 400, 0, -200),
													  new AttackFrame(6, Assets.bruno0UpAirRight[1], brunoUpAirRightHurtboxes1, null, 200, 400, 0, -200),
													  new AttackFrame(6, Assets.bruno0UpAirRight[0], brunoUpAirRightHurtboxes0, null, 200, 400, 0, -200)},
			
													 {new AttackFrame(3, Assets.bruno1UpAirRight[0], brunoUpAirRightHurtboxes0, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.bruno1UpAirRight[1], brunoUpAirRightHurtboxes1, null, 200, 400, 0, -200),
													  new AttackFrame(6, Assets.bruno1UpAirRight[2], brunoUpAirRightHurtboxes1, brunoUpAirRightHitboxes, 200, 400, 0, -200),
													  new AttackFrame(4, Assets.bruno1UpAirRight[2], brunoUpAirRightHurtboxes1, null, 200, 400, 0, -200),
													  new AttackFrame(6, Assets.bruno1UpAirRight[1], brunoUpAirRightHurtboxes1, null, 200, 400, 0, -200),
													  new AttackFrame(6, Assets.bruno1UpAirRight[0], brunoUpAirRightHurtboxes0, null, 200, 400, 0, -200)}};
		
		
		brunoUpAirRight = new Attack[] {new Attack(brunoUpAirRightFrames[0], 6, brunoUpAirDamage, 0, -25, 7, 30, brunoCollisionbox),
										new Attack(brunoUpAirRightFrames[1], 6, brunoUpAirDamage, 0, -25, 7, 30, brunoCollisionbox)};
		
		
		brunoUpAirLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												  new Hurtbox(84, 191, 12),
												  new Hurtbox(130, 170, 12),
											      new Hurtbox(84, 170, 12),
												  new Hurtbox(113, 150, 18),
												  new Hurtbox(91, 150, 15),
												  new Hurtbox(113, 130, 15),
												  new Hurtbox(90, 130, 15),
												  new Hurtbox(120, 100, 27),
												  new Hurtbox(90, 105, 12),
											      new Hurtbox(90, 83, 12),
												  new Hurtbox(72, 105, 9),
												  new Hurtbox(56, 105, 9),
												  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		brunoUpAirLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												 new Hurtbox(84, 191, 12),
												 new Hurtbox(130, 170, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(113, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(115, 105, 17),
												 new Hurtbox(115, 82, 12),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(85, 83, 14),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9)};
		
		
		brunoUpAirLeftHitboxes = new Hitbox[] {new Hitbox(95, 0, 25),
											   new Hitbox(95, -30, 20),
											   new Hitbox(95, -60, 20),
											   new Hitbox(95, -90, 20)};
		
		brunoUpAirLeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.bruno0UpAirLeft[0], brunoUpAirLeftHurtboxes0, null, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.bruno0UpAirLeft[1], brunoUpAirLeftHurtboxes1, null, 200, 400, 0, -200),
													 new AttackFrame(6, Assets.bruno0UpAirLeft[2], brunoUpAirLeftHurtboxes1, brunoUpAirLeftHitboxes, 200, 400, 0, -200),
													 new AttackFrame(4, Assets.bruno0UpAirLeft[2], brunoUpAirLeftHurtboxes1, null, 200, 400, 0, -200),
													 new AttackFrame(6, Assets.bruno0UpAirLeft[1], brunoUpAirLeftHurtboxes1, null, 200, 400, 0, -200),
													 new AttackFrame(4, Assets.bruno0UpAirLeft[0], brunoUpAirLeftHurtboxes0, null, 200, 400, 0, -200)},
			
													{new AttackFrame(3, Assets.bruno1UpAirLeft[0], brunoUpAirLeftHurtboxes0, null, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.bruno1UpAirLeft[1], brunoUpAirLeftHurtboxes1, null, 200, 400, 0, -200),
													 new AttackFrame(6, Assets.bruno1UpAirLeft[2], brunoUpAirLeftHurtboxes1, brunoUpAirLeftHitboxes, 200, 400, 0, -200),
													 new AttackFrame(4, Assets.bruno1UpAirLeft[2], brunoUpAirLeftHurtboxes1, null, 200, 400, 0, -200),
													 new AttackFrame(6, Assets.bruno1UpAirLeft[1], brunoUpAirLeftHurtboxes1, null, 200, 400, 0, -200),
													 new AttackFrame(4, Assets.bruno1UpAirLeft[0], brunoUpAirLeftHurtboxes0, null, 200, 400, 0, -200)}};
		
		
		brunoUpAirLeft = new Attack[] {new Attack(brunoUpAirLeftFrames[0], 6, brunoUpAirDamage, 0, -25, 7, 30, brunoCollisionbox),
									   new Attack(brunoUpAirLeftFrames[1], 6, brunoUpAirDamage, 0, -25, 7, 30, brunoCollisionbox)};
		
		
		
		brunoSideSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.bruno0FairRight[4], brunoFairRightHurtboxes, null, 200, 200),
															new AttackFrame(4, Assets.bruno0SideSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200),
															new AttackFrame(4, Assets.bruno0SideSpecialRight[1], brunoFairRightHurtboxes, null, 200, 200),
															new AttackFrame(10, Assets.bruno0SideSpecialRight[2], brunoFairRightHurtboxes, null, 200, 200)},
			
														   {new AttackFrame(4, Assets.bruno1FairRight[4], brunoFairRightHurtboxes, null, 200, 200),
															new AttackFrame(4, Assets.bruno1SideSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200),
															new AttackFrame(4, Assets.bruno1SideSpecialRight[1], brunoFairRightHurtboxes, null, 200, 200),
															new AttackFrame(10, Assets.bruno1SideSpecialRight[2], brunoFairRightHurtboxes, null, 200, 200)}};
															
		brunoSideSpecialRight = new Attack[] {new Attack(brunoSideSpecialRightFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
											  new Attack(brunoSideSpecialRightFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		brunoSideSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.bruno0FairLeft[4], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(4, Assets.bruno0SideSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(4, Assets.bruno0SideSpecialLeft[1], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(10, Assets.bruno0SideSpecialLeft[2], brunoFairLeftHurtboxes, null, 200, 200)},
												
														  {new AttackFrame(4, Assets.bruno1FairLeft[4], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(4, Assets.bruno1SideSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(4, Assets.bruno1SideSpecialLeft[1], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(10, Assets.bruno1SideSpecialLeft[2], brunoFairLeftHurtboxes, null, 200, 200)}};
			
		brunoSideSpecialLeft = new Attack[] {new Attack(brunoSideSpecialLeftFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
											 new Attack(brunoSideSpecialLeftFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
			
			
		
		brunoNeutralSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.bruno0NeutralSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(4, Assets.bruno0NeutralSpecialRight[1], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(4, Assets.bruno0NeutralSpecialRight[2], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(6, Assets.bruno0NeutralSpecialRight[3], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(6, Assets.bruno0NeutralSpecialRight[4], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(6, Assets.bruno0NeutralSpecialRight[5], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(14, Assets.bruno0NeutralSpecialRight[6], brunoFairRightHurtboxes, null, 200, 200)},
			
															  {new AttackFrame(4, Assets.bruno1NeutralSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(4, Assets.bruno1NeutralSpecialRight[1], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(4, Assets.bruno1NeutralSpecialRight[2], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(6, Assets.bruno1NeutralSpecialRight[3], brunoFairRightHurtboxes, null, 200, 200),
														   	   new AttackFrame(6, Assets.bruno1NeutralSpecialRight[4], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(6, Assets.bruno1NeutralSpecialRight[5], brunoFairRightHurtboxes, null, 200, 200),
															   new AttackFrame(14, Assets.bruno1NeutralSpecialRight[6], brunoFairRightHurtboxes, null, 200, 200)}};
															   
		
		brunoNeutralSpecialRight = new Attack[] {new Attack(brunoNeutralSpecialRightFrames[0], 7, 0, 0, 0, 0, 0, brunoCollisionbox),
												 new Attack(brunoNeutralSpecialRightFrames[1], 7, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		brunoNeutralSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.bruno0NeutralSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(4, Assets.bruno0NeutralSpecialLeft[1], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(4, Assets.bruno0NeutralSpecialLeft[2], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(6, Assets.bruno0NeutralSpecialLeft[3], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(6, Assets.bruno0NeutralSpecialLeft[4], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(6, Assets.bruno0NeutralSpecialLeft[5], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(14, Assets.bruno0NeutralSpecialLeft[6], brunoFairLeftHurtboxes, null, 200, 200)},
												
															 {new AttackFrame(4, Assets.bruno1NeutralSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(4, Assets.bruno1NeutralSpecialLeft[1], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(4, Assets.bruno1NeutralSpecialLeft[2], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(6, Assets.bruno1NeutralSpecialLeft[3], brunoFairLeftHurtboxes, null, 200, 200),
														   	  new AttackFrame(6, Assets.bruno1NeutralSpecialLeft[4], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(6, Assets.bruno1NeutralSpecialLeft[5], brunoFairLeftHurtboxes, null, 200, 200),
															  new AttackFrame(14, Assets.bruno1NeutralSpecialLeft[6], brunoFairLeftHurtboxes, null, 200, 200)}};
			   

	   brunoNeutralSpecialLeft = new Attack[] {new Attack(brunoNeutralSpecialLeftFrames[0], 7, 0, 0, 0, 0, 0, brunoCollisionbox),
					   						   new Attack(brunoNeutralSpecialLeftFrames[1], 7, 0, 0, 0, 0, 0, brunoCollisionbox)};
	   
	   
	   brunoUpSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(80, Assets.bruno0UpSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200)},
		   												
	   												    {new AttackFrame(80, Assets.bruno1UpSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200)}};
	   												    
	   brunoUpSpecialRight = new Attack[] {new Attack(brunoUpSpecialRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
			   							   new Attack(brunoUpSpecialRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
	   
	   
	   brunoUpSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(80, Assets.bruno0UpSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200)},
				
			    									   {new AttackFrame(80, Assets.bruno1UpSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200)}};
			    
	   brunoUpSpecialLeft = new Attack[] {new Attack(brunoUpSpecialLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
			   							  new Attack(brunoUpSpecialLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   //CAROL
	   
	   carolCollisionbox = new Collisionbox(50, 50, 100, 100);
	   
	   carolShieldingHurtbox = new Hurtbox[] {new Hurtbox(100, 100, 80)};
		
	   carolShieldingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0ShieldingRight[0], carolShieldingHurtbox, null, 200, 200)},
		   												{new AttackFrame(1, Assets.carol1ShieldingRight[0], carolShieldingHurtbox, null, 200, 200)},
		   												{new AttackFrame(1, Assets.supercarol0ShieldingRight[0], carolShieldingHurtbox, null, 200, 200)},
		   												{new AttackFrame(1, Assets.supercarol1ShieldingRight[0], carolShieldingHurtbox, null, 200, 200)}};
			
		
	   carolShieldingRight = new Attack[] {new Attack(carolShieldingRightFrames[0], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										   new Attack(carolShieldingRightFrames[1], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										   new Attack(carolShieldingRightFrames[2], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										   new Attack(carolShieldingRightFrames[3], 1, 0, 0, 0, 0, 0, carolCollisionbox)};
		
		
	   carolShieldHitRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0ShieldHitRight[0], carolShieldingHurtbox, null, 200, 200)},
														{new AttackFrame(1, Assets.carol1ShieldHitRight[0], carolShieldingHurtbox, null, 200, 200)},
														{new AttackFrame(1, Assets.supercarol0ShieldHitRight[0], carolShieldingHurtbox, null, 200, 200)},
														{new AttackFrame(1, Assets.supercarol1ShieldHitRight[0], carolShieldingHurtbox, null, 200, 200)}};
		
	   carolShieldHitRight = new Attack[] {new Attack(carolShieldHitRightFrames[0], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										   new Attack(carolShieldHitRightFrames[1], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										   new Attack(carolShieldHitRightFrames[2], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										   new Attack(carolShieldHitRightFrames[3], 1, 0, 0, 0, 0, 0, carolCollisionbox)};
		
		
	   carolShieldingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0ShieldingLeft[0], carolShieldingHurtbox, null, 200, 200)},
													   {new AttackFrame(1, Assets.carol1ShieldingLeft[0], carolShieldingHurtbox, null, 200, 200)},
													   {new AttackFrame(1, Assets.supercarol0ShieldingLeft[0], carolShieldingHurtbox, null, 200, 200)},
													   {new AttackFrame(1, Assets.supercarol1ShieldingLeft[0], carolShieldingHurtbox, null, 200, 200)}};
		
	   carolShieldingLeft = new Attack[] {new Attack(carolShieldingLeftFrames[0], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										  new Attack(carolShieldingLeftFrames[1], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										  new Attack(carolShieldingLeftFrames[2], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										  new Attack(carolShieldingLeftFrames[3], 1, 0, 0, 0, 0, 0, carolCollisionbox)};
		
		
		
	   carolShieldHitLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0ShieldHitLeft[0], carolShieldingHurtbox, null, 200, 200)},
													   {new AttackFrame(1, Assets.carol1ShieldHitLeft[0], carolShieldingHurtbox, null, 200, 200)},
													   {new AttackFrame(1, Assets.supercarol0ShieldHitLeft[0], carolShieldingHurtbox, null, 200, 200)},
													   {new AttackFrame(1, Assets.supercarol1ShieldHitLeft[0], carolShieldingHurtbox, null, 200, 200)}};
		
	   carolShieldHitLeft = new Attack[] {new Attack(carolShieldHitLeftFrames[0], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										  new Attack(carolShieldHitLeftFrames[1], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										  new Attack(carolShieldHitLeftFrames[2], 1, 0, 0, 0, 0, 0, carolCollisionbox),
										  new Attack(carolShieldHitLeftFrames[3], 1, 0, 0, 0, 0, 0, carolCollisionbox)};
		
		
	   carolParryRightFrames = new AttackFrame[] {new AttackFrame(1, Assets.carol0ParryRight, null, null, 200, 200),
												  new AttackFrame(1, Assets.carol1ParryRight, null, null, 200, 200),
												  new AttackFrame(1, Assets.supercarol0ParryRight, null, null, 200, 200),
												  new AttackFrame(1, Assets.supercarol1ParryRight, null, null, 200, 200)};
		
	   carolParryLeftFrames = new AttackFrame[] {new AttackFrame(1, Assets.carol0ParryLeft, null, null, 200, 200),
				   								 new AttackFrame(1, Assets.carol1ParryLeft, null, null, 200, 200),
				   								 new AttackFrame(1, Assets.supercarol0ParryLeft, null, null, 200, 200),
				   								 new AttackFrame(1, Assets.supercarol1ParryLeft, null, null, 200, 200)};
	   
	   
	   carolStandingRightHurtboxes = new Hurtbox[] {new Hurtbox(77, 191, 12),
													new Hurtbox(126, 191, 12),
													new Hurtbox(80, 170, 12),
													new Hurtbox(126, 170, 12),
													new Hurtbox(90, 150, 18),
													new Hurtbox(113, 150, 18),
													new Hurtbox(100, 130, 15),
													new Hurtbox(80, 100, 27),
													new Hurtbox(115, 105, 12),
													new Hurtbox(110, 83, 12),
													new Hurtbox(128, 120, 9),
													new Hurtbox(144, 120, 9),
											 		new Hurtbox(100, 50, 35),
													new Hurtbox(100, 75, 9),
													new Hurtbox(45, 60, 40),
													new Hurtbox(45, 110, 30),
													new Hurtbox(45, 155, 25)};
	   
	   carolStandingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)},
		   											   {new AttackFrame(1, Assets.carol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)},
		   											   {new AttackFrame(1, Assets.supercarol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)},
		   											   {new AttackFrame(1, Assets.supercarol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)}};
	   
	   carolStandingRight = new Attack[] {new Attack(carolStandingRightFrames[0], 1, 0, 0, 0, 0, 0, carolCollisionbox),
			   							  new Attack(carolStandingRightFrames[1], 1, 0, 0, 0, 0, 0, carolCollisionbox),
			   							  new Attack(carolStandingRightFrames[2], 1, 0, 0, 0, 0, 0, carolCollisionbox),
			   							  new Attack(carolStandingRightFrames[3], 1, 0, 0, 0, 0, 0, carolCollisionbox)};
	   
	   carolStandingLeftHurtboxes = new Hurtbox[] {new Hurtbox(123, 191, 12),
												   new Hurtbox(74, 191, 12),
												   new Hurtbox(120, 170, 12),
												   new Hurtbox(74, 170, 12),
												   new Hurtbox(110, 150, 18),
												   new Hurtbox(87, 150, 18),
												   new Hurtbox(100, 130, 15),
											       new Hurtbox(120, 100, 27),
												   new Hurtbox(85, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(72, 120, 9),
												   new Hurtbox(56, 120, 9),
											 	   new Hurtbox(100, 50, 35),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(155, 60, 40),
												   new Hurtbox(155, 110, 30),
												   new Hurtbox(155, 155, 25)};
	   
	   carolStandingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)},
	   												  {new AttackFrame(1, Assets.carol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)},
	   												  {new AttackFrame(1, Assets.supercarol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)},
	   												  {new AttackFrame(1, Assets.supercarol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)}};
	   
	   carolStandingLeft = new Attack[] {new Attack(carolStandingLeftFrames[0], 1, 0, 0, 0, 0, 0, carolCollisionbox),
			   							 new Attack(carolStandingLeftFrames[1], 1, 0, 0, 0, 0, 0, carolCollisionbox),
			   							 new Attack(carolStandingLeftFrames[2], 1, 0, 0, 0, 0, 0, carolCollisionbox),
			   							 new Attack(carolStandingLeftFrames[3], 1, 0, 0, 0, 0, 0, carolCollisionbox)};
	   
	   
	   carolWalkingRightHurtboxes = new Hurtbox[] {new Hurtbox(87, 191, 12),
												   new Hurtbox(116, 191, 12),
												   new Hurtbox(80, 170, 12),
												   new Hurtbox(126, 170, 12),
												   new Hurtbox(90, 150, 18),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(100, 130, 15),
												   new Hurtbox(80, 100, 27),
												   new Hurtbox(115, 105, 12),
												   new Hurtbox(110, 83, 12),
												   new Hurtbox(128, 120, 9),
												   new Hurtbox(144, 120, 9),
											 	   new Hurtbox(100, 50, 35),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(45, 60, 40),
												   new Hurtbox(45, 110, 30),
												   new Hurtbox(45, 155, 25)};
	   
	   carolWalkingRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.carol0WalkingRight[0], carolWalkingRightHurtboxes, null, 200, 200),
		   											   new AttackFrame(4, Assets.carol0WalkingRight[1], carolStandingRightHurtboxes, null, 200, 200),
		   											   new AttackFrame(4, Assets.carol0WalkingRight[2], carolWalkingRightHurtboxes, null, 200, 200),
		   											   new AttackFrame(4, Assets.carol0WalkingRight[3], carolStandingRightHurtboxes, null, 200, 200)},
		   
	   												  {new AttackFrame(4, Assets.carol1WalkingRight[0], carolWalkingRightHurtboxes, null, 200, 200),
			   										   new AttackFrame(4, Assets.carol1WalkingRight[1], carolStandingRightHurtboxes, null, 200, 200),
			   										   new AttackFrame(4, Assets.carol1WalkingRight[2], carolWalkingRightHurtboxes, null, 200, 200),
			   										   new AttackFrame(4, Assets.carol1WalkingRight[3], carolStandingRightHurtboxes, null, 200, 200)},
	   												  
	   												  {new AttackFrame(4, Assets.supercarol0WalkingRight[0], carolWalkingRightHurtboxes, null, 200, 200),
				   									   new AttackFrame(4, Assets.supercarol0WalkingRight[1], carolStandingRightHurtboxes, null, 200, 200),
				   									   new AttackFrame(4, Assets.supercarol0WalkingRight[2], carolWalkingRightHurtboxes, null, 200, 200),
				   									   new AttackFrame(4, Assets.supercarol0WalkingRight[3], carolStandingRightHurtboxes, null, 200, 200)},
	   												
	   												  {new AttackFrame(4, Assets.supercarol1WalkingRight[0], carolWalkingRightHurtboxes, null, 200, 200),
					   								   new AttackFrame(4, Assets.supercarol1WalkingRight[1], carolStandingRightHurtboxes, null, 200, 200),
					   								   new AttackFrame(4, Assets.supercarol1WalkingRight[2], carolWalkingRightHurtboxes, null, 200, 200),
					   								   new AttackFrame(4, Assets.supercarol1WalkingRight[3], carolStandingRightHurtboxes, null, 200, 200)}};
		   											   
	   carolWalkingRight = new Attack[] {new Attack(carolWalkingRightFrames[0], 4, 0, 0, 0, 0, 0, carolCollisionbox),
			   							 new Attack(carolWalkingRightFrames[1], 4, 0, 0, 0, 0, 0, carolCollisionbox),
			   							 new Attack(carolWalkingRightFrames[2], 4, 0, 0, 0, 0, 0, carolCollisionbox),
			   							 new Attack(carolWalkingRightFrames[3], 4, 0, 0, 0, 0, 0, carolCollisionbox)};
	    
	   carolWalkingLeftHurtboxes = new Hurtbox[] {new Hurtbox(113, 191, 12),
												  new Hurtbox(84, 191, 12),
												  new Hurtbox(120, 170, 12),
												  new Hurtbox(74, 170, 12),
												  new Hurtbox(110, 150, 18),
												  new Hurtbox(87, 150, 18),
												  new Hurtbox(100, 130, 15),
											      new Hurtbox(120, 100, 27),
												  new Hurtbox(85, 105, 12),
												  new Hurtbox(90, 83, 12),
												  new Hurtbox(72, 120, 9),
												  new Hurtbox(56, 120, 9),
											 	  new Hurtbox(100, 50, 35),
												  new Hurtbox(100, 75, 9),
												  new Hurtbox(155, 60, 40),
												  new Hurtbox(155, 110, 30),
												  new Hurtbox(155, 155, 25)};
	   
	   carolWalkingLeftFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.carol0WalkingLeft[0], carolWalkingLeftHurtboxes, null, 200, 200),
		   											  new AttackFrame(4, Assets.carol0WalkingLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
		   											  new AttackFrame(4, Assets.carol0WalkingLeft[2], carolWalkingLeftHurtboxes, null, 200, 200),
		   											  new AttackFrame(4, Assets.carol0WalkingLeft[3], carolStandingLeftHurtboxes, null, 200, 200)},
		   
	   												 {new AttackFrame(4, Assets.carol1WalkingLeft[0], carolWalkingLeftHurtboxes, null, 200, 200),
			   										  new AttackFrame(4, Assets.carol1WalkingLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
			   										  new AttackFrame(4, Assets.carol1WalkingLeft[2], carolWalkingLeftHurtboxes, null, 200, 200),
			   										  new AttackFrame(4, Assets.carol1WalkingLeft[3], carolStandingLeftHurtboxes, null, 200, 200)},
	   												 
	   												{new AttackFrame(4, Assets.supercarol0WalkingLeft[0], carolWalkingLeftHurtboxes, null, 200, 200),
				   								     new AttackFrame(4, Assets.supercarol0WalkingLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
				   							         new AttackFrame(4, Assets.supercarol0WalkingLeft[2], carolWalkingLeftHurtboxes, null, 200, 200),
				   									 new AttackFrame(4, Assets.supercarol0WalkingLeft[3], carolStandingLeftHurtboxes, null, 200, 200)},
	   												
	   												{new AttackFrame(4, Assets.supercarol1WalkingLeft[0], carolWalkingLeftHurtboxes, null, 200, 200),
					   							     new AttackFrame(4, Assets.supercarol1WalkingLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
					   								 new AttackFrame(4, Assets.supercarol1WalkingLeft[2], carolWalkingLeftHurtboxes, null, 200, 200),
					   								 new AttackFrame(4, Assets.supercarol1WalkingLeft[3], carolStandingLeftHurtboxes, null, 200, 200)}};
		   											   
	   carolWalkingLeft = new Attack[] {new Attack(carolWalkingLeftFrames[0], 4, 0, 0, 0, 0, 0, carolCollisionbox),
			   						    new Attack(carolWalkingLeftFrames[1], 4, 0, 0, 0, 0, 0, carolCollisionbox),
			   						    new Attack(carolWalkingLeftFrames[2], 4, 0, 0, 0, 0, 0, carolCollisionbox),
			   						    new Attack(carolWalkingLeftFrames[3], 4, 0, 0, 0, 0, 0, carolCollisionbox)};
	   
	   
		carolJabRightHurtboxes0 = new Hurtbox[] {new Hurtbox(77, 191, 12),
												 new Hurtbox(126, 191, 12),
												 new Hurtbox(80, 170, 12),
												 new Hurtbox(126, 170, 12),
												 new Hurtbox(90, 150, 18),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(100, 130, 15),
												 new Hurtbox(80, 100, 27),
												 new Hurtbox(115, 105, 12),
												 new Hurtbox(110, 83, 12),
												 new Hurtbox(128, 120, 9),
										 		 new Hurtbox(100, 50, 35),
												 new Hurtbox(100, 75, 9),
												 new Hurtbox(45, 60, 40),
												 new Hurtbox(45, 110, 30),
												 new Hurtbox(45, 155, 25),
												 new Hurtbox(140, 100, 15)};
		
		carolJabRightHurtboxes1 = new Hurtbox[] {new Hurtbox(77, 191, 12),
												 new Hurtbox(126, 191, 12),
												 new Hurtbox(80, 170, 12),
												 new Hurtbox(126, 170, 12),
												 new Hurtbox(90, 150, 18),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(100, 130, 15),
												 new Hurtbox(80, 100, 27),
												 new Hurtbox(115, 105, 12),
												 new Hurtbox(110, 83, 12),
												 new Hurtbox(128, 120, 9),
										 		 new Hurtbox(100, 50, 35),
												 new Hurtbox(100, 75, 9),
												 new Hurtbox(45, 60, 40),
												 new Hurtbox(45, 110, 30),
												 new Hurtbox(45, 155, 25)};
		
		
		carolJabRightHitboxes0 = new Hitbox[] {new Hitbox(160, 100, 15)};
		
		carolJabRightHitboxes1 = new Hitbox[] {new Hitbox(160, 100, 15),
											   new Hitbox(170, 100, 15)};
		
		carolJabRightHitboxes2 = new Hitbox[] {new Hitbox(160, 100, 15),
				  				 			   new Hitbox(180, 100, 15)};
		
		carolJabRightFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.carol0JabRight[0], carolStandingRightHurtboxes, null, 200, 200),
												    new AttackFrame(2, Assets.carol0JabRight[1], carolStandingRightHurtboxes, null, 200, 200),
												    new AttackFrame(2, Assets.carol0JabRight[2], carolJabRightHurtboxes0, carolJabRightHitboxes0, 200, 200),
												    new AttackFrame(2, Assets.carol0JabRight[3], carolJabRightHurtboxes0, carolJabRightHitboxes1, 200, 200),
												    new AttackFrame(2, Assets.carol0JabRight[4], carolJabRightHurtboxes0, carolJabRightHitboxes2, 200, 200),
												    new AttackFrame(10, Assets.carol0JabRight[5], carolJabRightHurtboxes0, null, 200, 200),
												    new AttackFrame(5, Assets.carol0JabRight[6], carolJabRightHurtboxes1, null, 200, 200)},
													
												   {new AttackFrame(2, Assets.carol1JabRight[0], carolStandingRightHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.carol1JabRight[1], carolStandingRightHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.carol1JabRight[2], carolJabRightHurtboxes0, carolJabRightHitboxes0, 200, 200),
													new AttackFrame(2, Assets.carol1JabRight[3], carolJabRightHurtboxes0, carolJabRightHitboxes1, 200, 200),
													new AttackFrame(2, Assets.carol1JabRight[4], carolJabRightHurtboxes0, carolJabRightHitboxes2, 200, 200),
													new AttackFrame(10, Assets.carol1JabRight[5], carolJabRightHurtboxes0, null, 200, 200),
													new AttackFrame(5, Assets.carol1JabRight[6], carolJabRightHurtboxes1, null, 200, 200)},
												   
												   {new AttackFrame(2, Assets.supercarol0JabRight[0], carolStandingRightHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.supercarol0JabRight[1], carolStandingRightHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.supercarol0JabRight[2], carolJabRightHurtboxes0, carolJabRightHitboxes0, 200, 200),
													new AttackFrame(2, Assets.supercarol0JabRight[3], carolJabRightHurtboxes0, carolJabRightHitboxes1, 200, 200),
													new AttackFrame(2, Assets.supercarol0JabRight[4], carolJabRightHurtboxes0, carolJabRightHitboxes2, 200, 200),
													new AttackFrame(10, Assets.supercarol0JabRight[5], carolJabRightHurtboxes0, null, 200, 200),
													new AttackFrame(5, Assets.supercarol0JabRight[6], carolJabRightHurtboxes1, null, 200, 200)},
												   
												   {new AttackFrame(2, Assets.supercarol1JabRight[0], carolStandingRightHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.supercarol1JabRight[1], carolStandingRightHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.supercarol1JabRight[2], carolJabRightHurtboxes0, carolJabRightHitboxes0, 200, 200),
													new AttackFrame(2, Assets.supercarol1JabRight[3], carolJabRightHurtboxes0, carolJabRightHitboxes1, 200, 200),
													new AttackFrame(2, Assets.supercarol1JabRight[4], carolJabRightHurtboxes0, carolJabRightHitboxes2, 200, 200),
													new AttackFrame(10, Assets.supercarol1JabRight[5], carolJabRightHurtboxes0, null, 200, 200),
													new AttackFrame(5, Assets.supercarol1JabRight[6], carolJabRightHurtboxes1, null, 200, 200)}};
													
													
		
		carolJabRight = new Attack[] {new Attack(carolJabRightFrames[0], 7, carolJabDamage, 12, -7, 7, 25, carolCollisionbox),
									  new Attack(carolJabRightFrames[1], 7, carolJabDamage, 12, -7, 7, 25, carolCollisionbox),
									  new Attack(carolJabRightFrames[2], 7, carolJabDamage, 12, -7, 7, 25, carolCollisionbox),
									  new Attack(carolJabRightFrames[3], 7, carolJabDamage, 12, -7, 7, 25, carolCollisionbox)};
	   
		
		
		carolJabLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(123, 191, 12),
												new Hurtbox(74, 191, 12),
												new Hurtbox(120, 170, 12),
												new Hurtbox(74, 170, 12),
												new Hurtbox(110, 150, 18),
												new Hurtbox(87, 150, 18),
												new Hurtbox(100, 130, 15),
												new Hurtbox(120, 100, 27),
												new Hurtbox(85, 105, 12),
												new Hurtbox(90, 83, 12),
												new Hurtbox(72, 120, 9),
										 		new Hurtbox(100, 50, 35),
												new Hurtbox(100, 75, 9),
												new Hurtbox(155, 60, 40),
												new Hurtbox(155, 110, 30),
												new Hurtbox(155, 155, 25),
												new Hurtbox(60, 100, 15)};
		
		carolJabLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(123, 191, 12),
												new Hurtbox(74, 191, 12),
												new Hurtbox(120, 170, 12),
												new Hurtbox(74, 170, 12),
												new Hurtbox(110, 150, 18),
												new Hurtbox(87, 150, 18),
												new Hurtbox(100, 130, 15),
												new Hurtbox(120, 100, 27),
												new Hurtbox(85, 105, 12),
												new Hurtbox(90, 83, 12),
												new Hurtbox(72, 120, 9),
										 		new Hurtbox(100, 50, 35),
												new Hurtbox(100, 75, 9),
												new Hurtbox(155, 60, 40),
												new Hurtbox(155, 110, 30),
												new Hurtbox(155, 155, 25)};
	
		
		carolJabLeftHitboxes0 = new Hitbox[] {new Hitbox(40, 100, 15)};
		
		carolJabLeftHitboxes1 = new Hitbox[] {new Hitbox(40, 100, 15),
											  new Hitbox(30, 100, 15)};
		
		carolJabLeftHitboxes2 = new Hitbox[] {new Hitbox(40, 100, 15),
				  				 			  new Hitbox(20, 100, 15)};
		
		carolJabLeftFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.carol0JabLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(2, Assets.carol0JabLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(2, Assets.carol0JabLeft[2], carolJabLeftHurtboxes0, carolJabLeftHitboxes0, 200, 200),
												   new AttackFrame(2, Assets.carol0JabLeft[3], carolJabLeftHurtboxes0, carolJabLeftHitboxes1, 200, 200),
												   new AttackFrame(2, Assets.carol0JabLeft[4], carolJabLeftHurtboxes0, carolJabLeftHitboxes2, 200, 200),
												   new AttackFrame(10, Assets.carol0JabLeft[5], carolJabLeftHurtboxes0, null, 200, 200),
												   new AttackFrame(5, Assets.carol0JabLeft[6], carolJabLeftHurtboxes1, null, 200, 200)},
													
												 {new AttackFrame(2, Assets.carol1JabLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
												  new AttackFrame(2, Assets.carol1JabLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
												  new AttackFrame(2, Assets.carol1JabLeft[2], carolJabLeftHurtboxes0, carolJabLeftHitboxes0, 200, 200),
												  new AttackFrame(2, Assets.carol1JabLeft[3], carolJabLeftHurtboxes0, carolJabLeftHitboxes1, 200, 200),
												  new AttackFrame(2, Assets.carol1JabLeft[4], carolJabLeftHurtboxes0, carolJabLeftHitboxes2, 200, 200),
												  new AttackFrame(10, Assets.carol1JabLeft[5], carolJabLeftHurtboxes0, null, 200, 200),
												  new AttackFrame(5, Assets.carol1JabLeft[6], carolJabLeftHurtboxes1, null, 200, 200)},
												 
												 {new AttackFrame(2, Assets.supercarol0JabLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
												  new AttackFrame(2, Assets.supercarol0JabLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
												  new AttackFrame(2, Assets.supercarol0JabLeft[2], carolJabLeftHurtboxes0, carolJabLeftHitboxes0, 200, 200),
												  new AttackFrame(2, Assets.supercarol0JabLeft[3], carolJabLeftHurtboxes0, carolJabLeftHitboxes1, 200, 200),
												  new AttackFrame(2, Assets.supercarol0JabLeft[4], carolJabLeftHurtboxes0, carolJabLeftHitboxes2, 200, 200),
												  new AttackFrame(10, Assets.supercarol0JabLeft[5], carolJabLeftHurtboxes0, null, 200, 200),
												  new AttackFrame(5, Assets.supercarol0JabLeft[6], carolJabLeftHurtboxes1, null, 200, 200)},
												 
												 {new AttackFrame(2, Assets.supercarol1JabLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
												  new AttackFrame(2, Assets.supercarol1JabLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
												  new AttackFrame(2, Assets.supercarol1JabLeft[2], carolJabLeftHurtboxes0, carolJabLeftHitboxes0, 200, 200),
												  new AttackFrame(2, Assets.supercarol1JabLeft[3], carolJabLeftHurtboxes0, carolJabLeftHitboxes1, 200, 200),
												  new AttackFrame(2, Assets.supercarol1JabLeft[4], carolJabLeftHurtboxes0, carolJabLeftHitboxes2, 200, 200),
												  new AttackFrame(10, Assets.supercarol1JabLeft[5], carolJabLeftHurtboxes0, null, 200, 200),
												  new AttackFrame(5, Assets.supercarol1JabLeft[6], carolJabLeftHurtboxes1, null, 200, 200)}};
		
		carolJabLeft = new Attack[] {new Attack(carolJabLeftFrames[0], 7, carolJabDamage, -12, -7, 7, 25, carolCollisionbox),
									 new Attack(carolJabLeftFrames[1], 7, carolJabDamage, -12, -7, 7, 25, carolCollisionbox),
									 new Attack(carolJabLeftFrames[2], 7, carolJabDamage, -12, -7, 7, 25, carolCollisionbox),
									 new Attack(carolJabLeftFrames[3], 7, carolJabDamage, -12, -7, 7, 25, carolCollisionbox)};
		
		
		
		
		carolDashRightHurtboxes0 = new Hurtbox[] {new Hurtbox(77, 191, 12),
												  new Hurtbox(126, 191, 12),
												  new Hurtbox(80, 170, 12),
												  new Hurtbox(126, 170, 12),
												  new Hurtbox(90, 150, 18),
												  new Hurtbox(113, 150, 18),
												  new Hurtbox(100, 130, 15),
												  new Hurtbox(80, 100, 27),
												  new Hurtbox(120, 105, 17),
												  new Hurtbox(110, 83, 12),
											 	  new Hurtbox(100, 50, 35),
												  new Hurtbox(100, 75, 9),
												  new Hurtbox(45, 60, 40),
												  new Hurtbox(45, 110, 30),
												  new Hurtbox(45, 155, 25)};
		
		carolDashRightHurtboxes1 = new Hurtbox[] {new Hurtbox(87, 191, 12),
												 new Hurtbox(116, 191, 12),
												 new Hurtbox(80, 170, 12),
												 new Hurtbox(126, 170, 12),
												 new Hurtbox(90, 150, 18),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(100, 130, 15),
												 new Hurtbox(80, 100, 27),
												 new Hurtbox(115, 105, 12),
												 new Hurtbox(110, 83, 12),
												 new Hurtbox(128, 100, 9),
												 new Hurtbox(144, 100, 9),
												 new Hurtbox(160, 100, 9),
										 		 new Hurtbox(100, 50, 35),
												 new Hurtbox(100, 75, 9),
												 new Hurtbox(45, 60, 40),
												 new Hurtbox(45, 110, 30),
												 new Hurtbox(45, 155, 25)};
		
		
		carolDashRightHitboxes0 = new Hitbox[] {new Hitbox(240, 80, 40),
												new Hitbox(240, 110, 40),
												new Hitbox(240, 140, 40)};
		
		carolDashRightHitboxes1 = new Hitbox[] {new Hitbox(240, 80, 40),
												new Hitbox(240, 110, 40),
												new Hitbox(240, 140, 40),
												new Hitbox(270, 60, 25),
												new Hitbox(270, 90, 25),
												new Hitbox(270, 120, 25),
												new Hitbox(270, 150, 25)};
		
		carolDashRightHitboxes2 = new Hitbox[] {new Hitbox(240, 80, 40),
												new Hitbox(240, 110, 40),
												new Hitbox(240, 140, 40),
												new Hitbox(280, 60, 30),
												new Hitbox(280, 90, 30),
												new Hitbox(280, 120, 30),
												new Hitbox(280, 150, 30)};
		
		carolDashRightHitboxes3 = new Hitbox[] {new Hitbox(240, 80, 40),
												new Hitbox(240, 110, 40),
												new Hitbox(240, 140, 40),
												new Hitbox(280, 60, 30),
												new Hitbox(280, 90, 30),
												new Hitbox(280, 120, 30),
												new Hitbox(280, 150, 30),
												new Hitbox(320, 55, 35),
												new Hitbox(320, 90, 35),
												new Hitbox(320, 120, 35),
												new Hitbox(320, 155, 35)};
		
		carolDashRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
													 new AttackFrame(4, Assets.carol0DashRight[0], carolDashRightHurtboxes0, null, 400, 200),
												     new AttackFrame(5, Assets.carol0DashRight[1], carolDashRightHurtboxes0, null, 400, 200),
												     new AttackFrame(2, Assets.carol0DashRight[2], carolDashRightHurtboxes1, null, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[3], carolDashRightHurtboxes1, carolDashRightHitboxes0, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[4], carolDashRightHurtboxes1, carolDashRightHitboxes1, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[5], carolDashRightHurtboxes1, carolDashRightHitboxes2, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[6], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[7], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[8], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[9], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(1, Assets.carol0DashRight[10], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(10, Assets.carol0DashRight[2], carolDashRightHurtboxes1, null, 400, 200)},
								
													{new AttackFrame(1, Assets.carol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
												     new AttackFrame(4, Assets.carol1DashRight[0], carolDashRightHurtboxes0, null, 400, 200),
													 new AttackFrame(5, Assets.carol1DashRight[1], carolDashRightHurtboxes0, null, 400, 200),
													 new AttackFrame(2, Assets.carol1DashRight[2], carolDashRightHurtboxes1, null, 400, 200),
													 new AttackFrame(1, Assets.carol1DashRight[3], carolDashRightHurtboxes1, carolDashRightHitboxes0, 400, 200),
													 new AttackFrame(1, Assets.carol1DashRight[4], carolDashRightHurtboxes1, carolDashRightHitboxes1, 400, 200),
													 new AttackFrame(1, Assets.carol1DashRight[5], carolDashRightHurtboxes1, carolDashRightHitboxes2, 400, 200),
													 new AttackFrame(1, Assets.carol1DashRight[6], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(1, Assets.carol1DashRight[7], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.carol1DashRight[8], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.carol1DashRight[9], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.carol1DashRight[10], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(10, Assets.carol1DashRight[2], carolDashRightHurtboxes1, null, 400, 200)},
													
													{new AttackFrame(1, Assets.supercarol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
													 new AttackFrame(4, Assets.supercarol0DashRight[0], carolDashRightHurtboxes0, null, 400, 200),
													 new AttackFrame(5, Assets.supercarol0DashRight[1], carolDashRightHurtboxes0, null, 400, 200),
													 new AttackFrame(2, Assets.supercarol0DashRight[2], carolDashRightHurtboxes1, null, 400, 200),
													 new AttackFrame(1, Assets.supercarol0DashRight[3], carolDashRightHurtboxes1, carolDashRightHitboxes0, 400, 200),
													 new AttackFrame(1, Assets.supercarol0DashRight[4], carolDashRightHurtboxes1, carolDashRightHitboxes1, 400, 200),
													 new AttackFrame(1, Assets.supercarol0DashRight[5], carolDashRightHurtboxes1, carolDashRightHitboxes2, 400, 200),
													 new AttackFrame(1, Assets.supercarol0DashRight[6], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(1, Assets.supercarol0DashRight[7], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.supercarol0DashRight[8], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.supercarol0DashRight[9], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.supercarol0DashRight[10], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(10, Assets.supercarol0DashRight[2], carolDashRightHurtboxes1, null, 400, 200)},
													
													{new AttackFrame(1, Assets.supercarol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
													 new AttackFrame(4, Assets.supercarol1DashRight[0], carolDashRightHurtboxes0, null, 400, 200),
													 new AttackFrame(5, Assets.supercarol1DashRight[1], carolDashRightHurtboxes0, null, 400, 200),
													 new AttackFrame(2, Assets.supercarol1DashRight[2], carolDashRightHurtboxes1, null, 400, 200),
													 new AttackFrame(1, Assets.supercarol1DashRight[3], carolDashRightHurtboxes1, carolDashRightHitboxes0, 400, 200),
													 new AttackFrame(1, Assets.supercarol1DashRight[4], carolDashRightHurtboxes1, carolDashRightHitboxes1, 400, 200),
													 new AttackFrame(1, Assets.supercarol1DashRight[5], carolDashRightHurtboxes1, carolDashRightHitboxes2, 400, 200),
													 new AttackFrame(1, Assets.supercarol1DashRight[6], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
												     new AttackFrame(1, Assets.supercarol1DashRight[7], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.supercarol1DashRight[8], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.supercarol1DashRight[9], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(1, Assets.supercarol1DashRight[10], carolDashRightHurtboxes1, carolDashRightHitboxes3, 400, 200),
													 new AttackFrame(10, Assets.supercarol1DashRight[2], carolDashRightHurtboxes1, null, 400, 200)}};
		
		carolDashRight = new Attack[] {new Attack(carolDashRightFrames[0], 13, carolDashDamage, 15, -10, 7, 25, carolCollisionbox),
									   new Attack(carolDashRightFrames[1], 13, carolDashDamage, 15, -10, 7, 25, carolCollisionbox),
									   new Attack(carolDashRightFrames[2], 13, carolDashDamage, 15, -10, 7, 25, carolCollisionbox),
									   new Attack(carolDashRightFrames[3], 13, carolDashDamage, 15, -10, 7, 25, carolCollisionbox)};
		
		
		carolDashLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(123, 191, 12),
												 new Hurtbox(74, 191, 12),
												 new Hurtbox(120, 170, 12),
												 new Hurtbox(74, 170, 12),
												 new Hurtbox(110, 150, 18),
												 new Hurtbox(87, 150, 18),
												 new Hurtbox(100, 130, 15),
												 new Hurtbox(120, 100, 27),
												 new Hurtbox(80, 105, 17),
												 new Hurtbox(90, 83, 12),
											 	 new Hurtbox(100, 50, 35),
												 new Hurtbox(100, 75, 9),
												 new Hurtbox(155, 60, 40),
												 new Hurtbox(155, 110, 30),
												 new Hurtbox(155, 155, 25)};
		
		carolDashLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(113, 191, 12),
											    new Hurtbox(84, 191, 12),
											    new Hurtbox(120, 170, 12),
											    new Hurtbox(74, 170, 12),
											    new Hurtbox(110, 150, 18),
											    new Hurtbox(87, 150, 18),
											    new Hurtbox(100, 130, 15),
										        new Hurtbox(120, 100, 27),
											    new Hurtbox(85, 105, 12),
											    new Hurtbox(90, 83, 12),
											    new Hurtbox(72, 100, 9),
											    new Hurtbox(56, 100, 9),
											    new Hurtbox(40, 100, 9),
										 	    new Hurtbox(100, 50, 35),
											    new Hurtbox(100, 75, 9),
											    new Hurtbox(155, 60, 40),
											    new Hurtbox(155, 110, 30),
											    new Hurtbox(155, 155, 25)};
									
		
		carolDashLeftHitboxes0 = new Hitbox[] {new Hitbox(-40, 80, 40),
											   new Hitbox(-40, 110, 40),
											   new Hitbox(-40, 140, 40)};
		
		carolDashLeftHitboxes1 = new Hitbox[] {new Hitbox(-40, 80, 40),
											   new Hitbox(-40, 110, 40),
											   new Hitbox(-40, 140, 40),
											   new Hitbox(-70, 60, 25),
											   new Hitbox(-70, 90, 25),
											   new Hitbox(-70, 120, 25),
											   new Hitbox(-70, 150, 25)};
		
		carolDashLeftHitboxes2 = new Hitbox[] {new Hitbox(-40, 80, 40),
											   new Hitbox(-40, 110, 40),
											   new Hitbox(-40, 140, 40),
											   new Hitbox(-80, 60, 30),
											   new Hitbox(-80, 90, 30),
											   new Hitbox(-80, 120, 30),
											   new Hitbox(-80, 150, 30)};
		
		carolDashLeftHitboxes3 = new Hitbox[] {new Hitbox(-40, 80, 40),
											   new Hitbox(-40, 110, 40),
											   new Hitbox(-40, 140, 40),
											   new Hitbox(-80, 60, 30),
											   new Hitbox(-80, 90, 30),
											   new Hitbox(-80, 120, 30),
											   new Hitbox(-80, 150, 30),
											   new Hitbox(-120, 55, 35),
											   new Hitbox(-120, 90, 35),
											   new Hitbox(-120, 120, 35),
											   new Hitbox(-120, 155, 35)};
		
		carolDashLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
													new AttackFrame(4, Assets.carol0DashLeft[0], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
												    new AttackFrame(5, Assets.carol0DashLeft[1], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
												    new AttackFrame(2, Assets.carol0DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[3], carolDashLeftHurtboxes1, carolDashLeftHitboxes0, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[4], carolDashLeftHurtboxes1, carolDashLeftHitboxes1, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[5], carolDashLeftHurtboxes1, carolDashLeftHitboxes2, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[6], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[7], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[8], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[9], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol0DashLeft[10], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
												    new AttackFrame(10, Assets.carol0DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)},
								
												   {new AttackFrame(1, Assets.carol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
												    new AttackFrame(4, Assets.carol1DashLeft[0], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
													new AttackFrame(5, Assets.carol1DashLeft[1], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
													new AttackFrame(2, Assets.carol1DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.carol1DashLeft[3], carolDashLeftHurtboxes1, carolDashLeftHitboxes0, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol1DashLeft[4], carolDashLeftHurtboxes1, carolDashLeftHitboxes1, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol1DashLeft[5], carolDashLeftHurtboxes1, carolDashLeftHitboxes2, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol1DashLeft[6], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol1DashLeft[7], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol1DashLeft[8], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol1DashLeft[9], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol1DashLeft[10], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(10, Assets.carol1DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)},
												   
												   {new AttackFrame(1, Assets.supercarol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
												    new AttackFrame(4, Assets.supercarol0DashLeft[0], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
													new AttackFrame(5, Assets.supercarol0DashLeft[1], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
													new AttackFrame(2, Assets.supercarol0DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0),
												    new AttackFrame(1, Assets.supercarol0DashLeft[3], carolDashLeftHurtboxes1, carolDashLeftHitboxes0, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol0DashLeft[4], carolDashLeftHurtboxes1, carolDashLeftHitboxes1, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol0DashLeft[5], carolDashLeftHurtboxes1, carolDashLeftHitboxes2, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol0DashLeft[6], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol0DashLeft[7], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol0DashLeft[8], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol0DashLeft[9], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol0DashLeft[10], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(10, Assets.supercarol0DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)},
												   
												   {new AttackFrame(1, Assets.supercarol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
												    new AttackFrame(4, Assets.supercarol1DashLeft[0], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
													new AttackFrame(5, Assets.supercarol1DashLeft[1], carolDashLeftHurtboxes0, null, 400, 200, -200, 0),
													new AttackFrame(2, Assets.supercarol1DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[3], carolDashLeftHurtboxes1, carolDashLeftHitboxes0, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[4], carolDashLeftHurtboxes1, carolDashLeftHitboxes1, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[5], carolDashLeftHurtboxes1, carolDashLeftHitboxes2, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[6], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[7], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[8], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[9], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(1, Assets.supercarol1DashLeft[10], carolDashLeftHurtboxes1, carolDashLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(10, Assets.supercarol1DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)}};
		
		carolDashLeft = new Attack[] {new Attack(carolDashLeftFrames[0], 13, carolDashDamage, -15, -10, 7, 25, carolCollisionbox),
									  new Attack(carolDashLeftFrames[1], 13, carolDashDamage, -15, -10, 7, 25, carolCollisionbox),
									  new Attack(carolDashLeftFrames[2], 13, carolDashDamage, -15, -10, 7, 25, carolCollisionbox),
									  new Attack(carolDashLeftFrames[3], 13, carolDashDamage, -15, -10, 7, 25, carolCollisionbox)};

		
		carolUpTiltRightHitboxes0 = new Hitbox[] {new Hitbox(175, 175, 30)};
		
		carolUpTiltRightHitboxes1 = new Hitbox[] {new Hitbox(175, 175, 30),
												  new Hitbox(175, 145, 30),
												  new Hitbox(175, 115, 30)};
		
		carolUpTiltRightHitboxes2 = new Hitbox[] {new Hitbox(175, 175, 30),
												  new Hitbox(175, 145, 30),
												  new Hitbox(175, 115, 30),
												  new Hitbox(175, 85, 30),
												  new Hitbox(175, 55, 30)};
		
		carolUpTiltRightHitboxes3 = new Hitbox[] {new Hitbox(175, 175, 30),
												  new Hitbox(175, 145, 30),
												  new Hitbox(175, 115, 30),
												  new Hitbox(175, 85, 30),
												  new Hitbox(175, 55, 30),
												  new Hitbox(175, 25, 30),
												  new Hitbox(175, -5, 30)};
		
		carolUpTiltRightHitboxes4 = new Hitbox[] {new Hitbox(175, 175, 30),
												  new Hitbox(175, 145, 30),
												  new Hitbox(175, 115, 30),
												  new Hitbox(175, 85, 30),
												  new Hitbox(175, 55, 30),
												  new Hitbox(175, 25, 30),
												  new Hitbox(175, -5, 30),
												  new Hitbox(175, -35, 30),
												  new Hitbox(175, -65, 30)};
		
		carolUpTiltRightHitboxes5 = new Hitbox[] {new Hitbox(175, 175, 30),
												  new Hitbox(175, 145, 30),
												  new Hitbox(175, 115, 30),
												  new Hitbox(175, 85, 30),
												  new Hitbox(175, 55, 30),
												  new Hitbox(175, 25, 30),
												  new Hitbox(175, -5, 30),
												  new Hitbox(175, -35, 30),
												  new Hitbox(175, -65, 30),
												  new Hitbox(175, -95, 30),
												  new Hitbox(175, -125, 30)};
		
		carolUpTiltRightHitboxes6 = new Hitbox[] {new Hitbox(175, 175, 30),
												  new Hitbox(175, 145, 30),
												  new Hitbox(175, 115, 30),
												  new Hitbox(175, 85, 30),
												  new Hitbox(175, 55, 30),
												  new Hitbox(175, 25, 30),
												  new Hitbox(175, -5, 30),
												  new Hitbox(175, -35, 30),
												  new Hitbox(175, -65, 30),
												  new Hitbox(175, -95, 30),
												  new Hitbox(175, -135, 30),
												  new Hitbox(175, -175, 30)};

		
		carolUpTiltRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(6, Assets.carol0UpTiltRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.carol0UpTiltRight[1], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.carol0UpTiltRight[2], carolStandingRightHurtboxes, carolUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(1, Assets.carol0UpTiltRight[3], carolStandingRightHurtboxes, carolUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol0UpTiltRight[4], carolStandingRightHurtboxes, carolUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol0UpTiltRight[5], carolStandingRightHurtboxes, carolUpTiltRightHitboxes3, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol0UpTiltRight[6], carolStandingRightHurtboxes, carolUpTiltRightHitboxes4, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol0UpTiltRight[7], carolStandingRightHurtboxes, carolUpTiltRightHitboxes5, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.carol0UpTiltRight[8], carolStandingRightHurtboxes, carolUpTiltRightHitboxes6, 200, 400, 0, -200),
													   new AttackFrame(7, Assets.carol0UpTiltRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(15, Assets.carol0UpTiltRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200)},
		
													  {new AttackFrame(1, Assets.carol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(6, Assets.carol1UpTiltRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.carol1UpTiltRight[1], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.carol1UpTiltRight[2], carolStandingRightHurtboxes, carolUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(1, Assets.carol1UpTiltRight[3], carolStandingRightHurtboxes, carolUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol1UpTiltRight[4], carolStandingRightHurtboxes, carolUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol1UpTiltRight[5], carolStandingRightHurtboxes, carolUpTiltRightHitboxes3, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol1UpTiltRight[6], carolStandingRightHurtboxes, carolUpTiltRightHitboxes4, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.carol1UpTiltRight[7], carolStandingRightHurtboxes, carolUpTiltRightHitboxes5, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.carol1UpTiltRight[8], carolStandingRightHurtboxes, carolUpTiltRightHitboxes6, 200, 400, 0, -200),
													   new AttackFrame(7, Assets.carol1UpTiltRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(15, Assets.carol1UpTiltRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200)},
													  
													  {new AttackFrame(1, Assets.supercarol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(6, Assets.supercarol0UpTiltRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
												       new AttackFrame(2, Assets.supercarol0UpTiltRight[1], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.supercarol0UpTiltRight[2], carolStandingRightHurtboxes, carolUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(1, Assets.supercarol0UpTiltRight[3], carolStandingRightHurtboxes, carolUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol0UpTiltRight[4], carolStandingRightHurtboxes, carolUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol0UpTiltRight[5], carolStandingRightHurtboxes, carolUpTiltRightHitboxes3, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol0UpTiltRight[6], carolStandingRightHurtboxes, carolUpTiltRightHitboxes4, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol0UpTiltRight[7], carolStandingRightHurtboxes, carolUpTiltRightHitboxes5, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.supercarol0UpTiltRight[8], carolStandingRightHurtboxes, carolUpTiltRightHitboxes6, 200, 400, 0, -200),
													   new AttackFrame(7, Assets.supercarol0UpTiltRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(15, Assets.supercarol0UpTiltRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200)},
													  
													  {new AttackFrame(1, Assets.supercarol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(6, Assets.supercarol1UpTiltRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.supercarol1UpTiltRight[1], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.supercarol1UpTiltRight[2], carolStandingRightHurtboxes, carolUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(1, Assets.supercarol1UpTiltRight[3], carolStandingRightHurtboxes, carolUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol1UpTiltRight[4], carolStandingRightHurtboxes, carolUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol1UpTiltRight[5], carolStandingRightHurtboxes, carolUpTiltRightHitboxes3, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol1UpTiltRight[6], carolStandingRightHurtboxes, carolUpTiltRightHitboxes4, 200, 400, 0, -200),
													   new AttackFrame(0, Assets.supercarol1UpTiltRight[7], carolStandingRightHurtboxes, carolUpTiltRightHitboxes5, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.supercarol1UpTiltRight[8], carolStandingRightHurtboxes, carolUpTiltRightHitboxes6, 200, 400, 0, -200),
													   new AttackFrame(7, Assets.supercarol1UpTiltRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													   new AttackFrame(15, Assets.supercarol1UpTiltRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200)}};
		
							   
		carolUpTiltRight = new Attack[] {new Attack(carolUpTiltRightFrames[0], 12, carolUpTiltDamage, 2, -28, 7, 50, carolCollisionbox, 0, -3),
				 						 new Attack(carolUpTiltRightFrames[1], 12, carolUpTiltDamage, 2, -28, 7, 50, carolCollisionbox, 0, -3),
				 						 new Attack(carolUpTiltRightFrames[2], 12, carolUpTiltDamage, 2, -28, 7, 50, carolCollisionbox, 0, -3),
				 						 new Attack(carolUpTiltRightFrames[3], 12, carolUpTiltDamage, 2, -28, 7, 50, carolCollisionbox, 0, -3)};

		
		
		carolUpTiltLeftHitboxes0 = new Hitbox[] {new Hitbox(25, 175, 30)};
		
		carolUpTiltLeftHitboxes1 = new Hitbox[] {new Hitbox(25, 175, 30),
												 new Hitbox(25, 145, 30),
												 new Hitbox(25, 115, 30)};
		
		carolUpTiltLeftHitboxes2 = new Hitbox[] {new Hitbox(25, 175, 30),
												 new Hitbox(25, 145, 30),
												 new Hitbox(25, 115, 30),
												 new Hitbox(25, 85, 30),
												 new Hitbox(25, 55, 30)};
		
		carolUpTiltLeftHitboxes3 = new Hitbox[] {new Hitbox(25, 175, 30),
												 new Hitbox(25, 145, 30),
												 new Hitbox(25, 115, 30),
												 new Hitbox(25, 85, 30),
												 new Hitbox(25, 55, 30),
												 new Hitbox(25, 25, 30),
												 new Hitbox(25, -5, 30)};
		
		carolUpTiltLeftHitboxes4 = new Hitbox[] {new Hitbox(25, 175, 30),
												 new Hitbox(25, 145, 30),
												 new Hitbox(25, 115, 30),
												 new Hitbox(25, 85, 30),
												 new Hitbox(25, 55, 30),
												 new Hitbox(25, 25, 30),
												 new Hitbox(25, -5, 30),
												 new Hitbox(25, -35, 30),
												 new Hitbox(25, -65, 30)};
		
		carolUpTiltLeftHitboxes5 = new Hitbox[] {new Hitbox(25, 175, 30),
												 new Hitbox(25, 145, 30),
												 new Hitbox(25, 115, 30),
												 new Hitbox(25, 85, 30),
												 new Hitbox(25, 55, 30),
												 new Hitbox(25, 25, 30),
												 new Hitbox(25, -5, 30),
												 new Hitbox(25, -35, 30),
												 new Hitbox(25, -65, 30),
												 new Hitbox(25, -95, 30),
												 new Hitbox(25, -125, 30)};
		
		carolUpTiltLeftHitboxes6 = new Hitbox[] {new Hitbox(25, 175, 30),
												 new Hitbox(25, 145, 30),
												 new Hitbox(25, 115, 30),
												 new Hitbox(25, 85, 30),
												 new Hitbox(25, 55, 30),
												 new Hitbox(25, 25, 30),
												 new Hitbox(25, -5, 30),
												 new Hitbox(25, -35, 30),
												 new Hitbox(25, -65, 30),
												 new Hitbox(25, -95, 30),
												 new Hitbox(25, -135, 30),
												 new Hitbox(25, -175, 30)};


		carolUpTiltLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.carol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(6, Assets.carol0UpTiltLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpTiltLeft[1], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpTiltLeft[2], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(1, Assets.carol0UpTiltLeft[3], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol0UpTiltLeft[4], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol0UpTiltLeft[5], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes3, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol0UpTiltLeft[6], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes4, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol0UpTiltLeft[7], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes5, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol0UpTiltLeft[8], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes6, 200, 400, 0, -200),
													  new AttackFrame(7, Assets.carol0UpTiltLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(15, Assets.carol0UpTiltLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)},
								
													 {new AttackFrame(1, Assets.carol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(6, Assets.carol1UpTiltLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpTiltLeft[1], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpTiltLeft[2], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(1, Assets.carol1UpTiltLeft[3], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol1UpTiltLeft[4], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol1UpTiltLeft[5], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes3, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol1UpTiltLeft[6], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes4, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.carol1UpTiltLeft[7], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes5, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol1UpTiltLeft[8], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes6, 200, 400, 0, -200),
													  new AttackFrame(7, Assets.carol1UpTiltLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(15, Assets.carol1UpTiltLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)},
													 
													 {new AttackFrame(1, Assets.supercarol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(6, Assets.supercarol0UpTiltLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpTiltLeft[1], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpTiltLeft[2], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(1, Assets.supercarol0UpTiltLeft[3], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol0UpTiltLeft[4], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol0UpTiltLeft[5], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes3, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol0UpTiltLeft[6], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes4, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol0UpTiltLeft[7], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes5, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol0UpTiltLeft[8], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes6, 200, 400, 0, -200),
													  new AttackFrame(7, Assets.supercarol0UpTiltLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(15, Assets.supercarol0UpTiltLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)},
													 
													 {new AttackFrame(1, Assets.supercarol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(6, Assets.supercarol1UpTiltLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpTiltLeft[1], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpTiltLeft[2], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(1, Assets.supercarol1UpTiltLeft[3], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol1UpTiltLeft[4], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol1UpTiltLeft[5], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes3, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol1UpTiltLeft[6], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes4, 200, 400, 0, -200),
													  new AttackFrame(0, Assets.supercarol1UpTiltLeft[7], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes5, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol1UpTiltLeft[8], carolStandingLeftHurtboxes, carolUpTiltLeftHitboxes6, 200, 400, 0, -200),
													  new AttackFrame(7, Assets.supercarol1UpTiltLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(15, Assets.supercarol1UpTiltLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)}};
		
		
		carolUpTiltLeft = new Attack[] {new Attack(carolUpTiltLeftFrames[0], 12, carolUpTiltDamage, -2, -28, 7, 50, carolCollisionbox, 0, -3),
										new Attack(carolUpTiltLeftFrames[1], 12, carolUpTiltDamage, -2, -28, 7, 50, carolCollisionbox, 0, -3),
										new Attack(carolUpTiltLeftFrames[2], 12, carolUpTiltDamage, -2, -28, 7, 50, carolCollisionbox, 0, -3),
										new Attack(carolUpTiltLeftFrames[3], 12, carolUpTiltDamage, -2, -28, 7, 50, carolCollisionbox, 0, -3)};

		
		carolBairRightHurtboxes = new Hurtbox[] {new Hurtbox(77, 191, 12),
												 new Hurtbox(126, 191, 12),
												 new Hurtbox(80, 170, 12),
												 new Hurtbox(126, 170, 12),
												 new Hurtbox(90, 150, 18),
												 new Hurtbox(113, 150, 18),
												 new Hurtbox(100, 130, 15),
												 new Hurtbox(80, 100, 27),
												 new Hurtbox(115, 105, 12),
												 new Hurtbox(110, 83, 12),
												 new Hurtbox(128, 120, 9),
												 new Hurtbox(144, 120, 9),
										 		 new Hurtbox(100, 50, 35),
												 new Hurtbox(100, 75, 9)};
	 	
		
		carolBairRightHitboxes = new Hitbox[] {new Hitbox(30, 47, 50),
											   new Hitbox(35, 110, 35),
											   new Hitbox(40, 145, 30),
											   new Hitbox(15, 150, 25)};


		carolBairRightFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.carol0BairRight[0], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(2, Assets.carol0BairRight[1], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.carol0BairRight[2], carolBairRightHurtboxes, carolBairRightHitboxes, 200, 200),
													 new AttackFrame(8, Assets.carol0BairRight[2], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.carol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)},
							
													{new AttackFrame(6, Assets.carol1BairRight[0], carolBairRightHurtboxes, null, 200, 200),
												     new AttackFrame(2, Assets.carol1BairRight[1], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.carol1BairRight[2], carolBairRightHurtboxes, carolBairRightHitboxes, 200, 200),
													 new AttackFrame(8, Assets.carol1BairRight[2], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.carol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)},
													
													{new AttackFrame(6, Assets.supercarol0BairRight[0], carolBairRightHurtboxes, null, 200, 200),
												     new AttackFrame(2, Assets.supercarol0BairRight[1], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.supercarol0BairRight[2], carolBairRightHurtboxes, carolBairRightHitboxes, 200, 200),
													 new AttackFrame(8, Assets.supercarol0BairRight[2], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.supercarol0StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)},
													
													{new AttackFrame(6, Assets.supercarol1BairRight[0], carolBairRightHurtboxes, null, 200, 200),
												     new AttackFrame(2, Assets.supercarol1BairRight[1], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.supercarol1BairRight[2], carolBairRightHurtboxes, carolBairRightHitboxes, 200, 200),
													 new AttackFrame(8, Assets.supercarol1BairRight[2], carolBairRightHurtboxes, null, 200, 200),
													 new AttackFrame(3, Assets.supercarol1StandingRight[0], carolStandingRightHurtboxes, null, 200, 200)}};
								 
		
		carolBairRight = new Attack[] {new Attack(carolBairRightFrames[0], 5, carolBairDamage, -25, -13, 7, 25, carolCollisionbox),
				   					   new Attack(carolBairRightFrames[1], 5, carolBairDamage, -25, -13, 7, 25, carolCollisionbox),
				   					   new Attack(carolBairRightFrames[2], 5, supercarolBairDamage, -30, -15, 7, 25, carolCollisionbox),
				   					   new Attack(carolBairRightFrames[3], 5, supercarolBairDamage, -30, -15, 7, 25, carolCollisionbox)};
		
		
		carolBairLeftHurtboxes = new Hurtbox[] {new Hurtbox(123, 191, 12),
												 new Hurtbox(74, 191, 12),
												 new Hurtbox(120, 170, 12),
												 new Hurtbox(74, 170, 12),
												 new Hurtbox(110, 150, 18),
												 new Hurtbox(87, 150, 18),
												 new Hurtbox(100, 130, 15),
												 new Hurtbox(120, 100, 27),
												 new Hurtbox(85, 105, 12),
												 new Hurtbox(90, 83, 12),
												 new Hurtbox(72, 120, 9),
												 new Hurtbox(56, 120, 9),
										 		 new Hurtbox(100, 50, 35),
												 new Hurtbox(100, 75, 9)};
		
		
		carolBairLeftHitboxes = new Hitbox[] {new Hitbox(170, 47, 50),
											  new Hitbox(165, 110, 35),
											  new Hitbox(160, 145, 30),
											  new Hitbox(185, 150, 25)};
		
		
		carolBairLeftFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.carol0BairLeft[0], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.carol0BairLeft[1], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.carol0BairLeft[2], carolBairLeftHurtboxes, carolBairLeftHitboxes, 200, 200),
													new AttackFrame(8, Assets.carol0BairLeft[2], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.carol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)},
		
												   {new AttackFrame(6, Assets.carol1BairLeft[0], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.carol1BairLeft[1], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.carol1BairLeft[2], carolBairLeftHurtboxes, carolBairLeftHitboxes, 200, 200),
													new AttackFrame(8, Assets.carol1BairLeft[2], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.carol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)},
												   
												   {new AttackFrame(6, Assets.supercarol0BairLeft[0], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.supercarol0BairLeft[1], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.supercarol0BairLeft[2], carolBairLeftHurtboxes, carolBairLeftHitboxes, 200, 200),
													new AttackFrame(8, Assets.supercarol0BairLeft[2], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.supercarol0StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)},
												   
												   {new AttackFrame(6, Assets.supercarol1BairLeft[0], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.supercarol1BairLeft[1], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.supercarol1BairLeft[2], carolBairLeftHurtboxes, carolBairLeftHitboxes, 200, 200),
													new AttackFrame(8, Assets.supercarol1BairLeft[2], carolBairLeftHurtboxes, null, 200, 200),
													new AttackFrame(3, Assets.supercarol1StandingLeft[0], carolStandingLeftHurtboxes, null, 200, 200)}};
		
		
		carolBairLeft = new Attack[] {new Attack(carolBairLeftFrames[0], 5, carolBairDamage, 25, -13, 7, 25, carolCollisionbox),
				   					  new Attack(carolBairLeftFrames[1], 5, carolBairDamage, 25, -13, 7, 25, carolCollisionbox),
				   			  		  new Attack(carolBairLeftFrames[2], 5, supercarolBairDamage, 30, -15, 7, 25, carolCollisionbox),
				   					  new Attack(carolBairLeftFrames[3], 5, supercarolBairDamage, 30, -15, 7, 25, carolCollisionbox)};
		
		
		
		
		carolFairRightHitboxes0 = new Hitbox[] {new  Hitbox(180, 118, 35)};
		
		carolFairRightHitboxes1 = new Hitbox[] {new  Hitbox(180, 118, 35),
												new  Hitbox(220, 118, 35)};
		
		carolFairRightHitboxes2 = new Hitbox[] {new  Hitbox(220, 118, 35, true),
												new Hitbox(260, 118, 35, true)};
		
		carolFairRightHitboxes3 = new Hitbox[] {new Hitbox(220, 118, 35, true),
												new Hitbox(260, 118, 35, true),
												new Hitbox(300, 118, 35, true)};
		
		
		carolFairRightFrames = new AttackFrame[][] {{new AttackFrame(9, Assets.carol0FairRight[0], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(1, Assets.carol0FairRight[1], carolStandingRightHurtboxes, carolFairRightHitboxes0, 400, 200),
													 new AttackFrame(1, Assets.carol0FairRight[2], carolStandingRightHurtboxes, carolFairRightHitboxes1, 400, 200),
													 new AttackFrame(1, Assets.carol0FairRight[3], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(0, Assets.carol0FairRight[3], carolStandingRightHurtboxes, carolFairRightHitboxes2, 400, 200),
													 new AttackFrame(0, Assets.carol0FairRight[4], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.carol0FairRight[5], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.carol0FairRight[6], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(5, Assets.carol0FairRight[7], carolStandingRightHurtboxes, null, 400, 200)},
			
													{new AttackFrame(9, Assets.carol1FairRight[0], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(1, Assets.carol1FairRight[1], carolStandingRightHurtboxes, carolFairRightHitboxes0, 400, 200),
												     new AttackFrame(1, Assets.carol1FairRight[2], carolStandingRightHurtboxes, carolFairRightHitboxes1, 400, 200),
												     new AttackFrame(1, Assets.carol1FairRight[3], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(0, Assets.carol1FairRight[3], carolStandingRightHurtboxes, carolFairRightHitboxes2, 400, 200),
													 new AttackFrame(0, Assets.carol1FairRight[4], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.carol1FairRight[5], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.carol1FairRight[6], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(5, Assets.carol1FairRight[7], carolStandingRightHurtboxes, null, 400, 200)},
													
													{new AttackFrame(9, Assets.supercarol0FairRight[0], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(1, Assets.supercarol0FairRight[1], carolStandingRightHurtboxes, carolFairRightHitboxes0, 400, 200),
												     new AttackFrame(1, Assets.supercarol0FairRight[2], carolStandingRightHurtboxes, carolFairRightHitboxes1, 400, 200),
												     new AttackFrame(1, Assets.supercarol0FairRight[3], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(0, Assets.supercarol0FairRight[3], carolStandingRightHurtboxes, carolFairRightHitboxes2, 400, 200),
													 new AttackFrame(0, Assets.supercarol0FairRight[4], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.supercarol0FairRight[5], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.supercarol0FairRight[6], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(5, Assets.supercarol0FairRight[7], carolStandingRightHurtboxes, null, 400, 200)},
													
													{new AttackFrame(9, Assets.supercarol1FairRight[0], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(1, Assets.supercarol1FairRight[1], carolStandingRightHurtboxes, carolFairRightHitboxes0, 400, 200),
												     new AttackFrame(1, Assets.supercarol1FairRight[2], carolStandingRightHurtboxes, carolFairRightHitboxes1, 400, 200),
												     new AttackFrame(1, Assets.supercarol1FairRight[3], carolStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(0, Assets.supercarol1FairRight[3], carolStandingRightHurtboxes, carolFairRightHitboxes2, 400, 200),
													 new AttackFrame(0, Assets.supercarol1FairRight[4], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.supercarol1FairRight[5], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(0, Assets.supercarol1FairRight[6], carolStandingRightHurtboxes, carolFairRightHitboxes3, 400, 200),
													 new AttackFrame(5, Assets.supercarol1FairRight[7], carolStandingRightHurtboxes, null, 400, 200)}};
													 
		carolFairRight = new Attack[] {new Attack(carolFairRightFrames[0], 9, carolFairDamage, 8, -8, 7, 20, carolCollisionbox, carolTipperFairDamage, 10, -10),
									   new Attack(carolFairRightFrames[1], 9, carolFairDamage, 8, -8, 7, 20, carolCollisionbox, carolTipperFairDamage, 10, -10),
									   new Attack(carolFairRightFrames[2], 9, supercarolFairDamage, 10, -10, 7, 20, carolCollisionbox, supercarolTipperFairDamage, 12, -12),
									   new Attack(carolFairRightFrames[3], 9, supercarolFairDamage, 10, -10, 7, 20, carolCollisionbox, supercarolTipperFairDamage, 12, -12)};
		
		
		carolFairLeftHitboxes0 = new Hitbox[] {new  Hitbox(20, 118, 35)};
		
		carolFairLeftHitboxes1 = new Hitbox[] {new  Hitbox(20, 118, 35),
											   new  Hitbox(-20, 118, 35)};
		
		carolFairLeftHitboxes2 = new Hitbox[] {new  Hitbox(-20, 118, 35, true),
											   new Hitbox(-60, 118, 35, true)};
		
		carolFairLeftHitboxes3 = new Hitbox[] {new Hitbox(-20, 118, 35, true),
												new Hitbox(-60, 118, 35, true),
											   new Hitbox(-100, 118, 35, true)};
		
		
		carolFairLeftFrames = new AttackFrame[][] {{new AttackFrame(9, Assets.carol0FairLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol0FairLeft[1], carolStandingLeftHurtboxes, carolFairLeftHitboxes0, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol0FairLeft[2], carolStandingLeftHurtboxes, carolFairLeftHitboxes1, 400, 200, -200, 0),
													new AttackFrame(1, Assets.carol0FairLeft[3], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													new AttackFrame(0, Assets.carol0FairLeft[3], carolStandingLeftHurtboxes, carolFairLeftHitboxes2, 400, 200, -200, 0),
													new AttackFrame(0, Assets.carol0FairLeft[4], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(0, Assets.carol0FairLeft[5], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(0, Assets.carol0FairLeft[6], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													new AttackFrame(5, Assets.carol0FairLeft[7], carolStandingLeftHurtboxes, null, 400, 200, -200, 0)},
			
													{new AttackFrame(9, Assets.carol1FairLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.carol1FairLeft[1], carolStandingLeftHurtboxes, carolFairLeftHitboxes0, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.carol1FairLeft[2], carolStandingLeftHurtboxes, carolFairLeftHitboxes1, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.carol1FairLeft[3], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.carol1FairLeft[3], carolStandingLeftHurtboxes, carolFairLeftHitboxes2, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.carol1FairLeft[4], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.carol1FairLeft[5], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.carol1FairLeft[6], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(5, Assets.carol1FairLeft[7], carolStandingLeftHurtboxes, null, 400, 200, -200, 0)},
													
													{new AttackFrame(9, Assets.supercarol0FairLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.supercarol0FairLeft[1], carolStandingLeftHurtboxes, carolFairLeftHitboxes0, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.supercarol0FairLeft[2], carolStandingLeftHurtboxes, carolFairLeftHitboxes1, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.supercarol0FairLeft[3], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol0FairLeft[3], carolStandingLeftHurtboxes, carolFairLeftHitboxes2, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol0FairLeft[4], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol0FairLeft[5], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol0FairLeft[6], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(5, Assets.supercarol0FairLeft[7], carolStandingLeftHurtboxes, null, 400, 200, -200, 0)},
													
													{new AttackFrame(9, Assets.supercarol1FairLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.supercarol1FairLeft[1], carolStandingLeftHurtboxes, carolFairLeftHitboxes0, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.supercarol1FairLeft[2], carolStandingLeftHurtboxes, carolFairLeftHitboxes1, 400, 200, -200, 0),
													 new AttackFrame(1, Assets.supercarol1FairLeft[3], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol1FairLeft[3], carolStandingLeftHurtboxes, carolFairLeftHitboxes2, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol1FairLeft[4], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol1FairLeft[5], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(0, Assets.supercarol1FairLeft[6], carolStandingLeftHurtboxes, carolFairLeftHitboxes3, 400, 200, -200, 0),
													 new AttackFrame(5, Assets.supercarol1FairLeft[7], carolStandingLeftHurtboxes, null, 400, 200, -200, 0)}};
													 
		carolFairLeft = new Attack[] {new Attack(carolFairLeftFrames[0], 9, carolFairDamage, -8, -8, 7, 20, carolCollisionbox, carolTipperFairDamage, -10, -10),
									  new Attack(carolFairLeftFrames[1], 9, carolFairDamage, -8, -8, 7, 20, carolCollisionbox, carolTipperFairDamage, -10, -10),
									  new Attack(carolFairLeftFrames[2], 9, supercarolFairDamage, -10, -10, 7, 20, carolCollisionbox, supercarolTipperFairDamage, -12, -12),
									  new Attack(carolFairLeftFrames[3], 9, supercarolFairDamage, -10, -10, 7, 20, carolCollisionbox, -12, -12)};
		
		
		
		carolUpAirHitboxes = new Hitbox[] {new Hitbox(100, -30, 45),
										   new Hitbox(160, -5, 50),
										   new Hitbox(40, -5, 50)};

		carolUpAirRightFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.carol0UpAirRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[1], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[2], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[3], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[4], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[5], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[6], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[7], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol0UpAirRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol0UpAirRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol0UpAirRight[10], carolStandingRightHurtboxes, null, 200, 400, 0, -200)},
		
													 {new AttackFrame(6, Assets.carol1UpAirRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[1], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[2], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[3], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[4], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[5], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[6], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[7], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol1UpAirRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol1UpAirRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirRight[10], carolStandingRightHurtboxes, null, 200, 400, 0, -200)},
													 
													 {new AttackFrame(6, Assets.supercarol0UpAirRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[1], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[2], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[3], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[4], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[5], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[6], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[7], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol0UpAirRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol0UpAirRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirRight[10], carolStandingRightHurtboxes, null, 200, 400, 0, -200)},
													 
													 {new AttackFrame(6, Assets.supercarol1UpAirRight[0], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[1], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[2], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[3], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[4], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[5], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[6], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[7], carolStandingRightHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol1UpAirRight[8], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol1UpAirRight[9], carolStandingRightHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirRight[10], carolStandingRightHurtboxes, null, 200, 400, 0, -200)}};
		
		
		carolUpAirRight = new Attack[] {new Attack(carolUpAirRightFrames[0], 11, carolUpAirDamage, 0, -20, 7, 25, carolCollisionbox),
										new Attack(carolUpAirRightFrames[1], 11, carolUpAirDamage, 0, -20, 7, 25, carolCollisionbox),
										new Attack(carolUpAirRightFrames[2], 11, supercarolUpAirDamage, 0, -24, 7, 25, carolCollisionbox),
										new Attack(carolUpAirRightFrames[3], 11, supercarolUpAirDamage, 0, -24, 7, 25, carolCollisionbox)};
		
		
		carolUpAirLeftFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.carol0UpAirLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[1], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[2], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[3], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[4], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[5], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[6], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[7], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													 new AttackFrame(5, Assets.carol0UpAirLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													 new AttackFrame(5, Assets.carol0UpAirLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													 new AttackFrame(2, Assets.carol0UpAirLeft[10], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)},
										
													 {new AttackFrame(6, Assets.carol1UpAirLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[1], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[2], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[3], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[4], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[5], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[6], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[7], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol1UpAirLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.carol1UpAirLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.carol1UpAirLeft[10], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)},
													 
													 {new AttackFrame(6, Assets.supercarol0UpAirLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[1], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[2], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[3], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[4], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[5], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[6], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[7], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol0UpAirLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol0UpAirLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol0UpAirLeft[10], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)},
													 
													 {new AttackFrame(6, Assets.supercarol1UpAirLeft[0], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[1], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[2], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[3], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[4], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[5], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[6], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[7], carolStandingLeftHurtboxes, carolUpAirHitboxes, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol1UpAirLeft[8], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.supercarol1UpAirLeft[9], carolStandingLeftHurtboxes, null, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.supercarol1UpAirLeft[10], carolStandingLeftHurtboxes, null, 200, 400, 0, -200)}};


			carolUpAirLeft = new Attack[] {new Attack(carolUpAirLeftFrames[0], 11, carolUpAirDamage, 0, -20, 7, 25, carolCollisionbox),
										   new Attack(carolUpAirLeftFrames[1], 11, carolUpAirDamage, 0, -20, 7, 25, carolCollisionbox),
										   new Attack(carolUpAirLeftFrames[2], 11, supercarolUpAirDamage, 0, -24, 7, 25, carolCollisionbox),
										   new Attack(carolUpAirLeftFrames[3], 11, supercarolUpAirDamage, 0, -24, 7, 25, carolCollisionbox)};
			
			
			
			carolSideSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.carol0DashRight[0], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(4, Assets.carol0DashRight[1], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(10, Assets.carol0DashRight[2], carolDashRightHurtboxes1, null, 400, 200)},
												
															   {new AttackFrame(4, Assets.carol1DashRight[0], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(4, Assets.carol1DashRight[1], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(10, Assets.carol1DashRight[2], carolDashRightHurtboxes1, null, 400, 200)},
															   
															   {new AttackFrame(4, Assets.supercarol0DashRight[0], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(4, Assets.supercarol0DashRight[1], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(10, Assets.supercarol0DashRight[2], carolDashRightHurtboxes1, null, 400, 200)},
															   
															   {new AttackFrame(4, Assets.supercarol1DashRight[0], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(4, Assets.supercarol1DashRight[1], carolStandingRightHurtboxes, null, 400, 200),
																new AttackFrame(10, Assets.supercarol1DashRight[2], carolDashRightHurtboxes1, null, 400, 200)}};
							
			carolSideSpecialRight = new Attack[] {new Attack(carolSideSpecialRightFrames[0], 3, 0, 0, 0, 0, 0, carolCollisionbox),
												  new Attack(carolSideSpecialRightFrames[1], 3, 0, 0, 0, 0, 0, carolCollisionbox),
												  new Attack(carolSideSpecialRightFrames[2], 3, 0, 0, 0, 0, 0, carolCollisionbox),
												  new Attack(carolSideSpecialRightFrames[3], 3, 0, 0, 0, 0, 0, carolCollisionbox)};
			
			carolSideSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.carol0DashLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(4, Assets.carol0DashLeft[1], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(10, Assets.carol0DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)},
												
															   {new AttackFrame(4, Assets.carol1DashLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(4, Assets.carol1DashLeft[1], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(10, Assets.carol1DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)},
															   
															   {new AttackFrame(4, Assets.supercarol0DashLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(4, Assets.supercarol0DashLeft[1], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(10, Assets.supercarol0DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)},
															   
															   {new AttackFrame(4, Assets.supercarol1DashLeft[0], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(4, Assets.supercarol1DashLeft[1], carolStandingLeftHurtboxes, null, 400, 200, -200, 0),
																new AttackFrame(10, Assets.supercarol1DashLeft[2], carolDashLeftHurtboxes1, null, 400, 200, -200, 0)}};

			carolSideSpecialLeft = new Attack[] {new Attack(carolSideSpecialLeftFrames[0], 3, 0, 0, 0, 0, 0, carolCollisionbox),
												 new Attack(carolSideSpecialLeftFrames[1], 3, 0, 0, 0, 0, 0, carolCollisionbox),
												 new Attack(carolSideSpecialLeftFrames[2], 3, 0, 0, 0, 0, 0, carolCollisionbox),
												 new Attack(carolSideSpecialLeftFrames[3], 3, 0, 0, 0, 0, 0, carolCollisionbox)};
			
			
			
			carolNeutralSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.carol0NeutralSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol0NeutralSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol0NeutralSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol0NeutralSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol0NeutralSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol0NeutralSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol0NeutralSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol0NeutralSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)},
												
																  {new AttackFrame(4, Assets.carol1NeutralSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol1NeutralSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol1NeutralSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol1NeutralSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol1NeutralSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol1NeutralSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol1NeutralSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.carol1NeutralSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)},
																  
																  {new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol0NeutralSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)},
																  
																  {new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
																   new AttackFrame(4, Assets.supercarol1NeutralSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)}};
				   

			carolNeutralSpecialRight = new Attack[] {new Attack(carolNeutralSpecialRightFrames[0], 8, 0, 0, 0, 0, 0, carolCollisionbox),
													 new Attack(carolNeutralSpecialRightFrames[1], 8, 0, 0, 0, 0, 0, carolCollisionbox),
													 new Attack(carolNeutralSpecialRightFrames[2], 8, 0, 0, 0, 0, 0, carolCollisionbox),
													 new Attack(carolNeutralSpecialRightFrames[3], 8, 0, 0, 0, 0, 0, carolCollisionbox)};
			
			
			carolNeutralSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.carol0NeutralSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol0NeutralSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol0NeutralSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol0NeutralSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol0NeutralSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol0NeutralSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol0NeutralSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol0NeutralSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)},
												
																 {new AttackFrame(4, Assets.carol1NeutralSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol1NeutralSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol1NeutralSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol1NeutralSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol1NeutralSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol1NeutralSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol1NeutralSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.carol1NeutralSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)},
																 
																 {new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol0NeutralSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)},
																 
																 {new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
																  new AttackFrame(4, Assets.supercarol1NeutralSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)}};


			carolNeutralSpecialLeft = new Attack[] {new Attack(carolNeutralSpecialLeftFrames[0], 8, 0, 0, 0, 0, 0, carolCollisionbox),
													new Attack(carolNeutralSpecialLeftFrames[1], 8, 0, 0, 0, 0, 0, carolCollisionbox),
													new Attack(carolNeutralSpecialLeftFrames[2], 8, 0, 0, 0, 0, 0, carolCollisionbox),
													new Attack(carolNeutralSpecialLeftFrames[3], 8, 0, 0, 0, 0, 0, carolCollisionbox)};
			
			
			
		   carolUpSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.carol0UpSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
			   												 new AttackFrame(3, Assets.carol0UpSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
			   												 new AttackFrame(3, Assets.carol0UpSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
			   												 new AttackFrame(3, Assets.carol0UpSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
			   												 new AttackFrame(3, Assets.carol0UpSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
			   												 new AttackFrame(3, Assets.carol0UpSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
			   												 new AttackFrame(3, Assets.carol0UpSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
			   												 new AttackFrame(3, Assets.carol0UpSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)},
					
				    										{new AttackFrame(3, Assets.carol1UpSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
				   											 new AttackFrame(3, Assets.carol1UpSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
				   											 new AttackFrame(3, Assets.carol1UpSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
				   											 new AttackFrame(3, Assets.carol1UpSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
				   											 new AttackFrame(3, Assets.carol1UpSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
				   											 new AttackFrame(3, Assets.carol1UpSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
				   											 new AttackFrame(3, Assets.carol1UpSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
				   											 new AttackFrame(3, Assets.carol1UpSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)},
				    										
				    										{new AttackFrame(3, Assets.supercarol0UpSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
					   										 new AttackFrame(3, Assets.supercarol0UpSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
					   										 new AttackFrame(3, Assets.supercarol0UpSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
					   										 new AttackFrame(3, Assets.supercarol0UpSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
					   										 new AttackFrame(3, Assets.supercarol0UpSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
					   										 new AttackFrame(3, Assets.supercarol0UpSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
					   										 new AttackFrame(3, Assets.supercarol0UpSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
					   										 new AttackFrame(3, Assets.supercarol0UpSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)},
				    										
				    										{new AttackFrame(3, Assets.supercarol1UpSpecialRight[0], carolStandingRightHurtboxes, null, 200, 200),
						   									 new AttackFrame(3, Assets.supercarol1UpSpecialRight[1], carolStandingRightHurtboxes, null, 200, 200),
						   									 new AttackFrame(3, Assets.supercarol1UpSpecialRight[2], carolStandingRightHurtboxes, null, 200, 200),
						   									 new AttackFrame(3, Assets.supercarol1UpSpecialRight[3], carolStandingRightHurtboxes, null, 200, 200),
						   									 new AttackFrame(3, Assets.supercarol1UpSpecialRight[4], carolStandingRightHurtboxes, null, 200, 200),
						   									 new AttackFrame(3, Assets.supercarol1UpSpecialRight[5], carolStandingRightHurtboxes, null, 200, 200),
						   									 new AttackFrame(3, Assets.supercarol1UpSpecialRight[6], carolStandingRightHurtboxes, null, 200, 200),
						   									 new AttackFrame(3, Assets.supercarol1UpSpecialRight[7], carolStandingRightHurtboxes, null, 200, 200)}};
				    
			carolUpSpecialRight = new Attack[] {new Attack(carolUpSpecialRightFrames[0], 8, 0, 0, 0, 0, 0, carolCollisionbox),
					   							new Attack(carolUpSpecialRightFrames[1], 8, 0, 0, 0, 0, 0, carolCollisionbox),
					   							new Attack(carolUpSpecialRightFrames[2], 8, 0, 0, 0, 0, 0, carolCollisionbox),
					   							new Attack(carolUpSpecialRightFrames[3], 8, 0, 0, 0, 0, 0, carolCollisionbox)};
			
			
		   carolUpSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.carol0UpSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
			   												new AttackFrame(3, Assets.carol0UpSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
			   												new AttackFrame(3, Assets.carol0UpSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
			   												new AttackFrame(3, Assets.carol0UpSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
			   												new AttackFrame(3, Assets.carol0UpSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
			   												new AttackFrame(3, Assets.carol0UpSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
			   												new AttackFrame(3, Assets.carol0UpSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
			   												new AttackFrame(3, Assets.carol0UpSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)},
										
														   {new AttackFrame(3, Assets.carol1UpSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
				   											new AttackFrame(3, Assets.carol1UpSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
				   											new AttackFrame(3, Assets.carol1UpSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
				   											new AttackFrame(3, Assets.carol1UpSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
				   											new AttackFrame(3, Assets.carol1UpSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
				   											new AttackFrame(3, Assets.carol1UpSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
				   											new AttackFrame(3, Assets.carol1UpSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
				   											new AttackFrame(3, Assets.carol1UpSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)},
														   
														   {new AttackFrame(3, Assets.supercarol0UpSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
					   										new AttackFrame(3, Assets.supercarol0UpSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
					   										new AttackFrame(3, Assets.supercarol0UpSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
					   										new AttackFrame(3, Assets.supercarol0UpSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
					   										new AttackFrame(3, Assets.supercarol0UpSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
					   										new AttackFrame(3, Assets.supercarol0UpSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
					   										new AttackFrame(3, Assets.supercarol0UpSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
					   										new AttackFrame(3, Assets.supercarol0UpSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)},
														   
														   {new AttackFrame(3, Assets.supercarol1UpSpecialLeft[0], carolStandingLeftHurtboxes, null, 200, 200),
						   									new AttackFrame(3, Assets.supercarol1UpSpecialLeft[1], carolStandingLeftHurtboxes, null, 200, 200),
						   									new AttackFrame(3, Assets.supercarol1UpSpecialLeft[2], carolStandingLeftHurtboxes, null, 200, 200),
						   									new AttackFrame(3, Assets.supercarol1UpSpecialLeft[3], carolStandingLeftHurtboxes, null, 200, 200),
						   									new AttackFrame(3, Assets.supercarol1UpSpecialLeft[4], carolStandingLeftHurtboxes, null, 200, 200),
						   									new AttackFrame(3, Assets.supercarol1UpSpecialLeft[5], carolStandingLeftHurtboxes, null, 200, 200),
						   									new AttackFrame(3, Assets.supercarol1UpSpecialLeft[6], carolStandingLeftHurtboxes, null, 200, 200),
						   									new AttackFrame(3, Assets.supercarol1UpSpecialLeft[7], carolStandingLeftHurtboxes, null, 200, 200)}};

			carolUpSpecialLeft = new Attack[] {new Attack(carolUpSpecialLeftFrames[0], 8, 0, 0, 0, 0, 0, carolCollisionbox),
											   new Attack(carolUpSpecialLeftFrames[1], 8, 0, 0, 0, 0, 0, carolCollisionbox),
											   new Attack(carolUpSpecialLeftFrames[2], 8, 0, 0, 0, 0, 0, carolCollisionbox),
											   new Attack(carolUpSpecialLeftFrames[3], 8, 0, 0, 0, 0, 0, carolCollisionbox)};
			
			
			

			
	}
	
	public static void createAttacks2() {
		
		
		
		//LACERDA
		
		lacerdaShieldingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0ShieldingRight[0], brunoShieldingHurtbox, null, 200, 200)},
														   {new AttackFrame(1, Assets.lacerda1ShieldingRight[0], brunoShieldingHurtbox, null, 200, 200)}};
			 

		lacerdaShieldingRight = new Attack[] {new Attack(lacerdaShieldingRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
											  new Attack(lacerdaShieldingRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		lacerdaShieldHitRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0ShieldHitRight[0], brunoShieldingHurtbox, null, 200, 200)},
						  								   {new AttackFrame(1, Assets.lacerda1ShieldHitRight[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		lacerdaShieldHitRight = new Attack[] {new Attack(lacerdaShieldHitRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
				 							   new Attack(lacerdaShieldHitRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		lacerdaShieldingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0ShieldingLeft[0], brunoShieldingHurtbox, null, 200, 200)},
														  {new AttackFrame(1, Assets.lacerda1ShieldingLeft[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		lacerdaShieldingLeft = new Attack[] {new Attack(lacerdaShieldingLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
											 new Attack(lacerdaShieldingLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		lacerdaShieldHitLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0ShieldHitLeft[0], brunoShieldingHurtbox, null, 200, 200)},
														  {new AttackFrame(1, Assets.lacerda1ShieldHitLeft[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		lacerdaShieldHitLeft = new Attack[] {new Attack(lacerdaShieldHitLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
											 new Attack(lacerdaShieldHitLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		lacerdaParryRightFrames = new AttackFrame[] {new AttackFrame(1, Assets.lacerda0ParryRight, null, null, 200, 200),
								  new AttackFrame(1, Assets.lacerda0ParryRight, null, null, 200, 200)};
		
		lacerdaParryLeftFrames = new AttackFrame[] {new AttackFrame(1, Assets.lacerda0ParryLeft, null, null, 200, 200),
													new AttackFrame(1, Assets.lacerda1ParryLeft, null, null, 200, 200)};
		
		
		
		
		lacerdaStandingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
														  {new AttackFrame(1, Assets.lacerda1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
		
		lacerdaStandingRight = new Attack[] {new Attack(lacerdaStandingRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
											 new Attack(lacerdaStandingRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		lacerdaStandingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
														 {new AttackFrame(1, Assets.lacerda1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		lacerdaStandingLeft = new Attack[] {new Attack(lacerdaStandingLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
											new Attack(lacerdaStandingLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		

		
		lacerdaWalkingRightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.lacerda0WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200),
														  new AttackFrame(4, Assets.lacerda0WalkingRight[1], brunoWalkingRightHurtboxes1, null, 200, 200),
														  new AttackFrame(4, Assets.lacerda0WalkingRight[2], brunoWalkingRightHurtboxes0, null, 200, 200),
														  new AttackFrame(4, Assets.lacerda0WalkingRight[3], brunoStandingRightHurtboxes, null, 200, 200)},
														
														 {new AttackFrame(4, Assets.lacerda1WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200),
														  new AttackFrame(4, Assets.lacerda1WalkingRight[1], brunoWalkingRightHurtboxes1, null, 200, 200),
													      new AttackFrame(4, Assets.lacerda1WalkingRight[2], brunoWalkingRightHurtboxes0, null, 200, 200),
														  new AttackFrame(4, Assets.lacerda1WalkingRight[3], brunoStandingRightHurtboxes, null, 200, 200)}};
		
		lacerdaWalkingRight = new Attack[] {new Attack(lacerdaWalkingRightFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
				  							new Attack(lacerdaWalkingRightFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		lacerdaWalkingLeftFrames = new AttackFrame[][] {{new AttackFrame(5, Assets.lacerda0WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200),
														 new AttackFrame(5, Assets.lacerda0WalkingLeft[1], brunoWalkingLeftHurtboxes1, null, 200, 200),
														 new AttackFrame(5, Assets.lacerda0WalkingLeft[2], brunoWalkingLeftHurtboxes0, null, 200, 200),
														 new AttackFrame(5, Assets.lacerda0WalkingLeft[3], brunoStandingLeftHurtboxes, null, 200, 200)},
									
		 											    {new AttackFrame(5, Assets.lacerda1WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200),
														 new AttackFrame(5, Assets.lacerda1WalkingLeft[1], brunoWalkingLeftHurtboxes1, null, 200, 200),
												         new AttackFrame(5, Assets.lacerda1WalkingLeft[2], brunoWalkingLeftHurtboxes0, null, 200, 200),
														 new AttackFrame(5, Assets.lacerda1WalkingLeft[3], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		lacerdaWalkingLeft = new Attack[] {new Attack(lacerdaWalkingLeftFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(lacerdaWalkingLeftFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		lacerdaJabRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												   new Hurtbox(116, 191, 12),
											       new Hurtbox(70, 170, 12),
												   new Hurtbox(116, 170, 12),
												   new Hurtbox(87, 150, 18),
											       new Hurtbox(110, 150, 15),
											       new Hurtbox(87, 130, 15),
											       new Hurtbox(110, 130, 15),
												   new Hurtbox(85, 107, 18),
												   new Hurtbox(85, 79, 15),
												   new Hurtbox(75, 92, 20),
												   new Hurtbox(110, 105, 12),
												   new Hurtbox(110, 83, 12),
												   new Hurtbox(124, 107, 9),
												   new Hurtbox(140, 107, 9),
												   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		lacerdaJabRightHurtboxes1 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												   new Hurtbox(116, 191, 12),
											       new Hurtbox(70, 170, 12),
												   new Hurtbox(116, 170, 12),
												   new Hurtbox(87, 150, 18),
											       new Hurtbox(110, 150, 15),
											       new Hurtbox(87, 130, 15),
											       new Hurtbox(110, 130, 15),
												   new Hurtbox(85, 107, 18),
												   new Hurtbox(85, 79, 15),
												   new Hurtbox(75, 92, 20),
												   new Hurtbox(110, 105, 12),
												   new Hurtbox(110, 83, 12),
												   new Hurtbox(124, 107, 9),
												   new Hurtbox(140, 107, 9),
												   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(130, 85, 10)};
		
		lacerdaJabRightHurtboxes2 = new Hurtbox[] {new Hurtbox(90, 191, 12),
												   new Hurtbox(116, 191, 12),
												   new Hurtbox(92, 172, 12),
											   	   new Hurtbox(116, 170, 12),
												   new Hurtbox(92, 150, 18),
												   new Hurtbox(110, 150, 15),
												   new Hurtbox(92, 130, 15),
												   new Hurtbox(110, 130, 15),
												   new Hurtbox(90, 107, 18),
												   new Hurtbox(90, 85, 17),
												   new Hurtbox(110, 105, 12),
												   new Hurtbox(110, 83, 12),
												   new Hurtbox(130, 100, 10),
												   new Hurtbox(138, 85, 10),
												   new Hurtbox(138, 70, 10),
												   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		
		lacerdaJabRightHitboxes = new Hitbox[] {new Hitbox(145, 55, 15),
								                new Hitbox(170, 55, 17)};
		
		
		lacerdaJabRightFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.lacerda0JabRight[0], brunoJabRightHurtboxes0, null, 200, 200),
													  new AttackFrame(1, Assets.lacerda0JabRight[1], lacerdaJabRightHurtboxes0, null, 200, 200),
													  new AttackFrame(1, Assets.lacerda0JabRight[2], lacerdaJabRightHurtboxes1, null, 200, 200),
													  new AttackFrame(4, Assets.lacerda0JabRight[3], lacerdaJabRightHurtboxes2, lacerdaJabRightHitboxes, 200, 200),
													  new AttackFrame(3, Assets.lacerda0JabRight[3], lacerdaJabRightHurtboxes2, null, 200, 200),
													  new AttackFrame(10, Assets.lacerda0JabRight[2], lacerdaJabRightHurtboxes1, null, 200, 200)},
														
													 {new AttackFrame(2, Assets.lacerda1JabRight[0], brunoJabRightHurtboxes0, null, 200, 200),
												      new AttackFrame(1, Assets.lacerda1JabRight[1], lacerdaJabRightHurtboxes0, null, 200, 200),
													  new AttackFrame(1, Assets.lacerda1JabRight[2], lacerdaJabRightHurtboxes1, null, 200, 200),
													  new AttackFrame(4, Assets.lacerda1JabRight[3], lacerdaJabRightHurtboxes2, lacerdaJabRightHitboxes, 200, 200),
													  new AttackFrame(3, Assets.lacerda1JabRight[3], lacerdaJabRightHurtboxes2, null, 200, 200),
													  new AttackFrame(10, Assets.lacerda1JabRight[2], lacerdaJabRightHurtboxes1, null, 200, 200)}};

        lacerdaJabRight = new Attack[] {new Attack(lacerdaJabRightFrames[0], 6, lacerdaJabDamage, 3, -17, 7, 30, brunoCollisionbox),
        							    new Attack(lacerdaJabRightFrames[1], 6,lacerdaJabDamage, 3, -17, 7, 30, brunoCollisionbox)};
        
        
		lacerdaJabLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												  new Hurtbox(84, 191, 12),
											      new Hurtbox(130, 170, 12),
												  new Hurtbox(84, 170, 12),
												  new Hurtbox(113, 150, 18),
											      new Hurtbox(90, 150, 15),
											      new Hurtbox(113, 130, 15),
											      new Hurtbox(90, 130, 15),
												  new Hurtbox(115, 107, 18),
												  new Hurtbox(115, 79, 15),
												  new Hurtbox(125, 92, 20),
												  new Hurtbox(90, 105, 12),
												  new Hurtbox(90, 83, 12),
												  new Hurtbox(76, 107, 9),
												  new Hurtbox(60, 107, 9),
												  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		lacerdaJabLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												  new Hurtbox(84, 191, 12),
											      new Hurtbox(130, 170, 12),
												  new Hurtbox(84, 170, 12),
												  new Hurtbox(113, 150, 18),
											      new Hurtbox(90, 150, 15),
											      new Hurtbox(113, 130, 15),
											      new Hurtbox(90, 130, 15),
												  new Hurtbox(115, 107, 18),
												  new Hurtbox(115, 79, 15),
												  new Hurtbox(125, 92, 20),
												  new Hurtbox(90, 105, 12),
												  new Hurtbox(90, 83, 12),
												  new Hurtbox(76, 107, 9),
												  new Hurtbox(60, 107, 9),
												  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9),
												  new Hurtbox(70, 85, 10)};
		
		lacerdaJabLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(110, 191, 12),
												  new Hurtbox(84, 191, 12),
												  new Hurtbox(108, 172, 12),
											   	  new Hurtbox(84, 170, 12),
												  new Hurtbox(108, 150, 18),
												  new Hurtbox(90, 150, 15),
												  new Hurtbox(108, 130, 15),
												  new Hurtbox(90, 130, 15),
												  new Hurtbox(110, 107, 18),
												  new Hurtbox(110, 85, 17),
												  new Hurtbox(90, 105, 12),
												  new Hurtbox(90, 83, 12),
												  new Hurtbox(70, 100, 10),
												  new Hurtbox(62, 85, 10),
												  new Hurtbox(62, 70, 10),
												  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		
		lacerdaJabLeftHitboxes = new Hitbox[] {new Hitbox(55, 55, 15),
											   new Hitbox(30, 55, 17)};
        
        
		lacerdaJabLeftFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.lacerda0JabLeft[0], brunoJabLeftHurtboxes0, null, 200, 200),
												     new AttackFrame(1, Assets.lacerda0JabLeft[1], lacerdaJabLeftHurtboxes0, null, 200, 200),
												     new AttackFrame(1, Assets.lacerda0JabLeft[2], lacerdaJabLeftHurtboxes1, null, 200, 200),
												     new AttackFrame(4, Assets.lacerda0JabLeft[3], lacerdaJabLeftHurtboxes2, lacerdaJabLeftHitboxes, 200, 200),
												     new AttackFrame(3, Assets.lacerda0JabLeft[3], lacerdaJabLeftHurtboxes2, null, 200, 200),
												     new AttackFrame(10, Assets.lacerda0JabLeft[2], lacerdaJabLeftHurtboxes1, null, 200, 200)},
								
												    {new AttackFrame(2, Assets.lacerda1JabLeft[0], brunoJabLeftHurtboxes0, null, 200, 200),
												     new AttackFrame(1, Assets.lacerda1JabLeft[1], lacerdaJabLeftHurtboxes0, null, 200, 200),
												     new AttackFrame(1, Assets.lacerda1JabLeft[2], lacerdaJabLeftHurtboxes1, null, 200, 200),
												     new AttackFrame(4, Assets.lacerda1JabLeft[3], lacerdaJabLeftHurtboxes2, lacerdaJabLeftHitboxes, 200, 200),
												     new AttackFrame(3, Assets.lacerda1JabLeft[3], lacerdaJabLeftHurtboxes2, null, 200, 200),
												     new AttackFrame(10, Assets.lacerda1JabLeft[2], lacerdaJabLeftHurtboxes1, null, 200, 200)}};

	    lacerdaJabLeft = new Attack[] {new Attack(lacerdaJabLeftFrames[0], 6, lacerdaJabDamage, -3, -17, 7, 30, brunoCollisionbox),
	    						       new Attack(lacerdaJabLeftFrames[1], 6, lacerdaJabDamage, -3, -17, 7, 30, brunoCollisionbox)};
	    
	    
	    
		lacerdaDashRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												    new Hurtbox(116, 191, 12),
											        new Hurtbox(70, 170, 12),
												    new Hurtbox(116, 170, 12),
												    new Hurtbox(87, 150, 18),
											        new Hurtbox(110, 150, 15),
											        new Hurtbox(87, 130, 15),
											        new Hurtbox(110, 130, 15),
												    new Hurtbox(85, 107, 18),
												    new Hurtbox(85, 79, 15),
												    new Hurtbox(75, 92, 15),
												    new Hurtbox(55, 88, 10),
												    new Hurtbox(47, 100, 10),
												    new Hurtbox(47, 120, 10),
												    new Hurtbox(110, 105, 12),
												    new Hurtbox(110, 83, 12),
												    new Hurtbox(124, 107, 9),
												    new Hurtbox(140, 107, 9),
												    new Hurtbox(100, 40, 30),
												    new Hurtbox(100, 75, 9)};
		
		lacerdaDashRightHurtboxes1 = new Hurtbox[] {new Hurtbox(70, 191, 12),
													new Hurtbox(120, 191, 12),
													new Hurtbox(80, 170, 12),
													new Hurtbox(115, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(85, 105, 17),
													new Hurtbox(85, 82, 12),
													new Hurtbox(110, 105, 12),
													new Hurtbox(110, 83, 12),
											 		new Hurtbox(100, 48, 30),
													new Hurtbox(100, 75, 9),
													new Hurtbox(135, 115, 10),
													new Hurtbox(65, 130, 12),
													new Hurtbox(65, 110, 12)};
		
		lacerdaDashRightHurtboxes2 = new Hurtbox[] {new Hurtbox(70, 191, 12),
													new Hurtbox(120, 191, 12),
													new Hurtbox(80, 170, 12),
													new Hurtbox(115, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(85, 105, 17),
													new Hurtbox(85, 82, 12),
													new Hurtbox(110, 105, 12),
													new Hurtbox(110, 83, 12),
											 		new Hurtbox(100, 48, 30),
													new Hurtbox(100, 75, 9),
													new Hurtbox(135, 115, 10),
													new Hurtbox(135, 150, 15)};
		
		
		lacerdaDashRightHitboxes = new Hitbox[] {new Hitbox(160, 155, 17),
												 new Hitbox(180, 155, 17),
												 new Hitbox(200, 155, 17),
												 new Hitbox(220, 155, 17),
												 new Hitbox(240, 155, 17)};
		

		
		lacerdaDashRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(4, Assets.lacerda0DashRight[0], lacerdaDashRightHurtboxes0, null, 400, 200),
												       new AttackFrame(5, Assets.lacerda0DashRight[1], lacerdaDashRightHurtboxes1, null, 400, 200),
												       new AttackFrame(3, Assets.lacerda0DashRight[2], lacerdaDashRightHurtboxes2, lacerdaDashRightHitboxes, 400, 200),
												       new AttackFrame(5, Assets.lacerda0DashRight[2], lacerdaDashRightHurtboxes2, null, 400, 200),
												       new AttackFrame(4, Assets.lacerda0DashRight[1], lacerdaDashRightHurtboxes1, null, 400, 200),
												       new AttackFrame(3, Assets.lacerda0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
							
													  {new AttackFrame(1, Assets.lacerda1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
												       new AttackFrame(4, Assets.lacerda1DashRight[0], lacerdaDashRightHurtboxes0, null, 400, 200),
													   new AttackFrame(5, Assets.lacerda1DashRight[1], lacerdaDashRightHurtboxes1, null, 400, 200),
													   new AttackFrame(3, Assets.lacerda1DashRight[2], lacerdaDashRightHurtboxes2, lacerdaDashRightHitboxes, 400, 200),
													   new AttackFrame(5, Assets.lacerda1DashRight[2], lacerdaDashRightHurtboxes2, null, 400, 200),
													   new AttackFrame(4, Assets.lacerda1DashRight[1], lacerdaDashRightHurtboxes1, null, 400, 200),
													   new AttackFrame(3, Assets.lacerda1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
		
		lacerdaDashRight = new Attack[] {new Attack(lacerdaDashRightFrames[0], 7, lacerdaDashDamage, 4, -15, 7, 30, brunoCollisionbox),
										 new Attack(lacerdaDashRightFrames[1], 7, lacerdaDashDamage, 4, -15, 7, 30, brunoCollisionbox)};
		
		
		lacerdaDashLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
											       new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
											       new Hurtbox(90, 150, 15),
											       new Hurtbox(113, 130, 15),
											       new Hurtbox(90, 130, 15),
												   new Hurtbox(115, 107, 18),
												   new Hurtbox(115, 79, 15),
												   new Hurtbox(125, 92, 15),
												   new Hurtbox(145, 88, 10),
												   new Hurtbox(153, 100, 10),
												   new Hurtbox(153, 120, 10),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(76, 107, 9),
												   new Hurtbox(60, 107, 9),
												   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		lacerdaDashLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(130, 191, 12),
												   new Hurtbox(80, 191, 12),
												   new Hurtbox(120, 170, 12),
												   new Hurtbox(85, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(115, 105, 17),
												   new Hurtbox(115, 82, 12),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
											 	   new Hurtbox(100, 48, 30),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(65, 115, 10),
												   new Hurtbox(135, 130, 12),
												   new Hurtbox(135, 110, 12)};
		
		lacerdaDashLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(130, 191, 12),
												   new Hurtbox(80, 191, 12),
												   new Hurtbox(120, 170, 12),
								    	           new Hurtbox(85, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(115, 105, 17),
												   new Hurtbox(115, 82, 12),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
											 	   new Hurtbox(100, 48, 30),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(65, 115, 10),
												   new Hurtbox(65, 150, 15)};
		
		
		lacerdaDashLeftHitboxes = new Hitbox[] {new Hitbox(40, 155, 17),
												new Hitbox(20, 155, 17),
												new Hitbox(0, 155, 17),
												new Hitbox(-20, 155, 17),
												new Hitbox(-40, 155, 17)};
								
		
		
		lacerdaDashLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(4, Assets.lacerda0DashLeft[0], lacerdaDashLeftHurtboxes0, null, 400, 200, -200, 0),
												      new AttackFrame(5, Assets.lacerda0DashLeft[1], lacerdaDashLeftHurtboxes1, null, 400, 200, -200, 0),
												      new AttackFrame(3, Assets.lacerda0DashLeft[2], lacerdaDashLeftHurtboxes2, lacerdaDashLeftHitboxes, 400, 200, -200, 0),
												      new AttackFrame(5, Assets.lacerda0DashLeft[2], lacerdaDashLeftHurtboxes2, null, 400, 200, -200, 0),
												      new AttackFrame(5, Assets.lacerda0DashLeft[1], lacerdaDashLeftHurtboxes1, null, 400, 200, -200, 0),
												      new AttackFrame(5, Assets.lacerda0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
								
													  {new AttackFrame(1, Assets.lacerda1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
												       new AttackFrame(4, Assets.lacerda1DashLeft[0], lacerdaDashLeftHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(5, Assets.lacerda1DashLeft[1], lacerdaDashLeftHurtboxes1, null, 400, 200, -200, 0),
												       new AttackFrame(3, Assets.lacerda1DashLeft[2], lacerdaDashLeftHurtboxes2, lacerdaDashLeftHitboxes, 400, 200, -200, 0),
													   new AttackFrame(5, Assets.lacerda1DashLeft[2], lacerdaDashLeftHurtboxes2, null, 400, 200, -200, 0),
													   new AttackFrame(5, Assets.lacerda1DashLeft[1], lacerdaDashLeftHurtboxes1, null, 400, 200, -200, 0),
													   new AttackFrame(5, Assets.lacerda1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		lacerdaDashLeft = new Attack[] {new Attack(lacerdaDashLeftFrames[0], 7, lacerdaDashDamage, -4, -15, 7, 30, brunoCollisionbox),
										new Attack(lacerdaDashLeftFrames[1], 7, lacerdaDashDamage, -4, -15, 7, 30, brunoCollisionbox)};
		
		
		
		lacerdaUpTiltRightHurtboxes0 = new Hurtbox[] {new Hurtbox(55, 191, 12),
													  new Hurtbox(116, 191, 12),
													  new Hurtbox(70, 175, 12),
													  new Hurtbox(116, 170, 12),
													  new Hurtbox(87, 150, 18),
													  new Hurtbox(110, 150, 15),
													  new Hurtbox(87, 130, 15),
													  new Hurtbox(110, 130, 15),
													  new Hurtbox(90, 107, 18),
												   	  new Hurtbox(110, 105, 12),
													  new Hurtbox(124, 127, 9),
													  new Hurtbox(140, 127, 9),
												 	  new Hurtbox(100, 62, 30),
												 	  new Hurtbox(128, 158, 15),
												 	  new Hurtbox(68, 125, 15)};
													
		
		lacerdaUpTiltRightHurtboxes1 = new Hurtbox[] {new Hurtbox(172, 100, 12),
													  new Hurtbox(165, 80, 12),
													  new Hurtbox(150, 60, 15),
													  new Hurtbox(130, 60, 15),
													  new Hurtbox(110, 60, 15),
													  new Hurtbox(90, 60, 15),
													  new Hurtbox(150, 40, 15),
													  new Hurtbox(130, 40, 15),
													  new Hurtbox(110, 40, 15),
													  new Hurtbox(90, 40, 15),
													  new Hurtbox(40, 50, 30),
													  new Hurtbox(100, 20, 10),
													  new Hurtbox(90, 5, 10)};
		
		lacerdaUpTiltRightHurtboxes2 = new Hurtbox[] {new Hurtbox(185, -10, 12),
													  new Hurtbox(165, -10, 12),
													  new Hurtbox(145, -15, 12),
													  new Hurtbox(125, 0, 15),
													  new Hurtbox(125, 20, 15),
													  new Hurtbox(125, 40, 15),
													  new Hurtbox(125, 60, 15),
													  new Hurtbox(105, 0, 15),
													  new Hurtbox(105, 20, 15),
													  new Hurtbox(105, 40, 15),
													  new Hurtbox(105, 60, 15),
													  new Hurtbox(115, 100, 30),
													  new Hurtbox(85, 35, 10),
													  new Hurtbox(75, 50, 10)};
		
		lacerdaUpTiltRightHurtboxes3 = new Hurtbox[] {new Hurtbox(25, 0, 12),
													  new Hurtbox(32, 20, 12),
													  new Hurtbox(32, 72, 12),
													  new Hurtbox(10, 78, 12),
													  new Hurtbox(47, 40, 15),
													  new Hurtbox(67, 40, 15),
													  new Hurtbox(87, 40, 15),
													  new Hurtbox(107, 40, 15),
													  new Hurtbox(47, 60, 15),
													  new Hurtbox(67, 60, 15),
													  new Hurtbox(87, 60, 15),
													  new Hurtbox(107, 60, 15),
													  new Hurtbox(157, 50, 30),
													  new Hurtbox(97, 80, 10),
													  new Hurtbox(107, 95, 10)};
		
		
		lacerdaUpTiltRightHitboxes0 = new Hitbox[] {new Hitbox(160, 35, 20),
													new Hitbox(185, 25, 30)};
		
		lacerdaUpTiltRightHitboxes1 = new Hitbox[] {new Hitbox(100, -25, 20),
													new Hitbox(90, -50, 30),
													new Hitbox(130, -40, 30),
													new Hitbox(160, -10, 30),
													new Hitbox(170, 20, 30)};
		
		
		
		lacerdaUpTiltRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
														 new AttackFrame(7, Assets.lacerda0UpTiltRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda0UpTiltRight[1], brunoWalkingRightHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda0UpTiltRight[2], lacerdaUpTiltRightHurtboxes1, lacerdaUpTiltRightHitboxes0, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda0UpTiltRight[3], lacerdaUpTiltRightHurtboxes2, lacerdaUpTiltRightHitboxes1, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda0UpTiltRight[4], lacerdaUpTiltRightHurtboxes3, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda0UpTiltRight[5], brunoWalkingRightHurtboxes1, null, 200, 400, 0, -200),
														 new AttackFrame(13, Assets.lacerda0UpTiltRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 400, 0, -200)},
									
														{new AttackFrame(1, Assets.lacerda1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
														 new AttackFrame(7, Assets.lacerda1UpTiltRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda1UpTiltRight[1], brunoWalkingRightHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda1UpTiltRight[2], lacerdaUpTiltRightHurtboxes1, lacerdaUpTiltRightHitboxes0, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda1UpTiltRight[3], lacerdaUpTiltRightHurtboxes2, lacerdaUpTiltRightHitboxes1, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda1UpTiltRight[4], lacerdaUpTiltRightHurtboxes3, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.lacerda1UpTiltRight[5], brunoWalkingRightHurtboxes1, null, 200, 400, 0, -200),
														 new AttackFrame(13, Assets.lacerda1UpTiltRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 400, 0, -200)}};
	
							   
		lacerdaUpTiltRight = new Attack[] {new Attack(lacerdaUpTiltRightFrames[0], 8, lacerdaUpTiltDamage, 0, -28, 7, 35, brunoCollisionbox),
				 						   new Attack(lacerdaUpTiltRightFrames[1], 8, lacerdaUpTiltDamage, 0, -28, 7, 35, brunoCollisionbox)};
		
		
		lacerdaUpTiltLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(145, 191, 12),
													 new Hurtbox(84, 191, 12),
													 new Hurtbox(130, 175, 12),
													 new Hurtbox(84, 170, 12),
													 new Hurtbox(113, 150, 18),
													 new Hurtbox(90, 150, 15),
													 new Hurtbox(113, 130, 15),
													 new Hurtbox(90, 130, 15),
													 new Hurtbox(110, 107, 18),
												   	 new Hurtbox(90, 105, 12),
													 new Hurtbox(76, 127, 9),
													 new Hurtbox(60, 127, 9),
												 	 new Hurtbox(100, 62, 30),
												 	 new Hurtbox(72, 158, 15),
												 	 new Hurtbox(132, 125, 15)};
							
		
		lacerdaUpTiltLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(28, 100, 12),
													 new Hurtbox(35, 80, 12),
													 new Hurtbox(50, 60, 15),
													 new Hurtbox(70, 60, 15),
													 new Hurtbox(90, 60, 15),
													 new Hurtbox(110, 60, 15),
													 new Hurtbox(50, 40, 15),
													 new Hurtbox(70, 40, 15),
													 new Hurtbox(90, 40, 15),
													 new Hurtbox(110, 40, 15),
													 new Hurtbox(160, 50, 30),
													 new Hurtbox(100, 20, 10),
													 new Hurtbox(110, 5, 10)};
		
		lacerdaUpTiltLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(15, -10, 12),
													 new Hurtbox(35, -10, 12),
													 new Hurtbox(55, -15, 12),
													 new Hurtbox(75, 0, 15),
													 new Hurtbox(75, 20, 15),
													 new Hurtbox(75, 40, 15),
													 new Hurtbox(75, 60, 15),
													 new Hurtbox(95, 0, 15),
													 new Hurtbox(95, 20, 15),
													 new Hurtbox(95, 40, 15),
													 new Hurtbox(95, 60, 15),
													 new Hurtbox(85, 100, 30),
													 new Hurtbox(115, 35, 10),
													 new Hurtbox(125, 50, 10)};
		
		lacerdaUpTiltLeftHurtboxes3 = new Hurtbox[] {new Hurtbox(175, 0, 12),
													 new Hurtbox(168, 20, 12),
													 new Hurtbox(168, 72, 12),
													 new Hurtbox(190, 78, 12),
													 new Hurtbox(153, 40, 15),
													 new Hurtbox(133, 40, 15),
													 new Hurtbox(113, 40, 15),
													 new Hurtbox(93, 40, 15),
													 new Hurtbox(153, 60, 15),
													 new Hurtbox(133, 60, 15),
													 new Hurtbox(113, 60, 15),
													 new Hurtbox(93, 60, 15),
													 new Hurtbox(43, 50, 30),
													 new Hurtbox(103, 80, 10),
													 new Hurtbox(93, 95, 10)};
		
		
		lacerdaUpTiltLeftHitboxes0 = new Hitbox[] {new Hitbox(40, 35, 20),
													   new Hitbox(15, 25, 30)};
		
		lacerdaUpTiltLeftHitboxes1 = new Hitbox[] {new Hitbox(100, -25, 20),
												   new Hitbox(110, -50, 30),
												   new Hitbox(70, -40, 30),
												   new Hitbox(40, -10, 30),
												   new Hitbox(30, 20, 30)};
		
		
		
		lacerdaUpTiltLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
														new AttackFrame(7, Assets.lacerda0UpTiltLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda0UpTiltLeft[1], brunoWalkingLeftHurtboxes0, null, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda0UpTiltLeft[2], lacerdaUpTiltLeftHurtboxes1, lacerdaUpTiltLeftHitboxes0, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda0UpTiltLeft[3], lacerdaUpTiltLeftHurtboxes2, lacerdaUpTiltLeftHitboxes1, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda0UpTiltLeft[4], lacerdaUpTiltLeftHurtboxes3, null, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda0UpTiltLeft[5], brunoWalkingLeftHurtboxes1, null, 200, 400, 0, -200),
														new AttackFrame(13, Assets.lacerda0UpTiltLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 400, 0, -200)},
									
													   {new AttackFrame(1, Assets.lacerda1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													    new AttackFrame(7, Assets.lacerda1UpTiltLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda1UpTiltLeft[1], brunoWalkingLeftHurtboxes0, null, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda1UpTiltLeft[2], lacerdaUpTiltLeftHurtboxes1, lacerdaUpTiltLeftHitboxes0, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda1UpTiltLeft[3], lacerdaUpTiltLeftHurtboxes2, lacerdaUpTiltLeftHitboxes1, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda1UpTiltLeft[4], lacerdaUpTiltLeftHurtboxes3, null, 200, 400, 0, -200),
														new AttackFrame(3, Assets.lacerda1UpTiltLeft[5], brunoWalkingLeftHurtboxes1, null, 200, 400, 0, -200),
														new AttackFrame(13, Assets.lacerda1UpTiltLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 400, 0, -200)}};
		
		
		lacerdaUpTiltLeft = new Attack[] {new Attack(lacerdaUpTiltLeftFrames[0], 8, lacerdaUpTiltDamage, 0, -28, 7, 35, brunoCollisionbox),
				   						  new Attack(lacerdaUpTiltLeftFrames[1], 8, lacerdaUpTiltDamage, 0, -28, 7, 35, brunoCollisionbox)};
		
		
		
		lacerdaBairRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													new Hurtbox(116, 191, 12),
													new Hurtbox(70, 170, 12),
													new Hurtbox(116, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(85, 105, 17),
													new Hurtbox(85, 82, 12),
													new Hurtbox(110, 105, 12),
													new Hurtbox(115, 83, 14),
											 		new Hurtbox(100, 40, 30),
													new Hurtbox(100, 75, 9),
													new Hurtbox(135, 107, 9)};
		
		lacerdaBairRightHurtboxes1 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													new Hurtbox(116, 191, 12),
													new Hurtbox(70, 170, 12),
													new Hurtbox(116, 170, 12),
													new Hurtbox(87, 150, 18),
													new Hurtbox(110, 150, 15),
													new Hurtbox(87, 130, 15),
													new Hurtbox(110, 130, 15),
													new Hurtbox(85, 105, 17),
													new Hurtbox(85, 82, 12),
													new Hurtbox(110, 105, 12),
													new Hurtbox(115, 83, 14),
											 		new Hurtbox(100, 40, 30),
													new Hurtbox(100, 75, 9),
													new Hurtbox(130, 65, 12)};
		
		lacerdaBairRightHurtboxes2 = new Hurtbox[] {new Hurtbox(72, 191, 12),
													new Hurtbox(116, 191, 12),
													new Hurtbox(75, 170, 12),
													new Hurtbox(116, 170, 12),
												    new Hurtbox(87, 150, 18),
												    new Hurtbox(110, 150, 15),
												    new Hurtbox(87, 130, 15),
												    new Hurtbox(110, 130, 15),
												    new Hurtbox(85, 107, 18),
												    new Hurtbox(85, 79, 15),
												    new Hurtbox(62, 92, 20),
												    new Hurtbox(110, 105, 12),
												    new Hurtbox(110, 83, 12),
												    new Hurtbox(100, 40, 30),
												    new Hurtbox(100, 75, 9)};
		
		lacerdaBairRightHurtboxes3 = new Hurtbox[] {new Hurtbox(67, 191, 12),
												    new Hurtbox(116, 191, 12),
											        new Hurtbox(70, 170, 12),
												    new Hurtbox(116, 170, 12),
												    new Hurtbox(87, 150, 18),
											        new Hurtbox(110, 150, 15),
											        new Hurtbox(87, 130, 15),
											        new Hurtbox(110, 130, 15),
												    new Hurtbox(85, 107, 18),
												    new Hurtbox(85, 79, 15),
												    new Hurtbox(75, 92, 15),
												    new Hurtbox(55, 88, 10),
												    new Hurtbox(45, 100, 10),
												    new Hurtbox(32, 110, 10),
												    new Hurtbox(20, 120, 10),
												    new Hurtbox(110, 105, 12),
												    new Hurtbox(110, 83, 12),
												    new Hurtbox(124, 107, 9),
												    new Hurtbox(140, 107, 9),
												    new Hurtbox(100, 40, 30),
												    new Hurtbox(100, 75, 9)};
		
		
		lacerdaBairRightHitboxes = new Hitbox[] {new Hitbox(10, 125, 17),
											      new Hitbox(-10, 125, 17),
											      new Hitbox(-30, 125, 17),
											      new Hitbox(-50, 125, 17),
											      new Hitbox(-70, 125, 17)};
										
		
		lacerdaBairRightFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.lacerda0BairRight[0], lacerdaBairRightHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda0BairRight[1], lacerdaBairRightHurtboxes1, null, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda0BairRight[2], lacerdaBairRightHurtboxes2, null, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda0BairRight[3], lacerdaDashRightHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(3, Assets.lacerda0BairRight[4], lacerdaBairRightHurtboxes3, lacerdaBairRightHitboxes, 400, 200, -200, 0),
													   new AttackFrame(4, Assets.lacerda0BairRight[3], lacerdaDashRightHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(6, Assets.lacerda0BairRight[2], lacerdaBairRightHurtboxes2, null, 400, 200, -200, 0),
													   new AttackFrame(10, Assets.lacerda0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
						
													  {new AttackFrame(2, Assets.lacerda1BairRight[0], lacerdaBairRightHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda1BairRight[1], lacerdaBairRightHurtboxes1, null, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda1BairRight[2], lacerdaBairRightHurtboxes2, null, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda1BairRight[3], lacerdaDashRightHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(3, Assets.lacerda1BairRight[4], lacerdaBairRightHurtboxes3, lacerdaBairRightHitboxes, 400, 200, -200, 0),
													   new AttackFrame(4, Assets.lacerda1BairRight[3], lacerdaDashRightHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(6, Assets.lacerda1BairRight[2], lacerdaBairRightHurtboxes2, null, 400, 200, -200, 0),
													   new AttackFrame(10, Assets.lacerda1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
									 
		
		lacerdaBairRight = new Attack[] {new Attack(lacerdaBairRightFrames[0], 8, lacerdaBairDamage, -15, -10, 7, 25, brunoCollisionbox),
					   				     new Attack(lacerdaBairRightFrames[1], 8, lacerdaBairDamage, -15, -10, 7, 25, brunoCollisionbox)};
		
		
		lacerdaBairLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
											       new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(115, 105, 17),
												   new Hurtbox(115, 82, 12),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(85, 83, 14),
											 	   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(65, 107, 9)};
		
		lacerdaBairLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
												   new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(115, 105, 17),
												   new Hurtbox(115, 82, 12),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(85, 83, 14),
											 	   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9),
												   new Hurtbox(70, 65, 12)};
		
		lacerdaBairLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(128, 191, 12),
												   new Hurtbox(84, 191, 12),
												   new Hurtbox(125, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
												   new Hurtbox(90, 150, 15),
												   new Hurtbox(113, 130, 15),
												   new Hurtbox(90, 130, 15),
												   new Hurtbox(115, 107, 18),
												   new Hurtbox(115, 79, 15),
												   new Hurtbox(138, 92, 20),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		lacerdaBairLeftHurtboxes3 = new Hurtbox[] {new Hurtbox(133, 191, 12),
												   new Hurtbox(84, 191, 12),
											       new Hurtbox(130, 170, 12),
												   new Hurtbox(84, 170, 12),
												   new Hurtbox(113, 150, 18),
											       new Hurtbox(90, 150, 15),
											       new Hurtbox(113, 130, 15),
											       new Hurtbox(90, 130, 15),
												   new Hurtbox(115, 107, 18),
												   new Hurtbox(115, 79, 15),
												   new Hurtbox(125, 92, 15),
												   new Hurtbox(145, 88, 10),
												   new Hurtbox(155, 100, 10),
												   new Hurtbox(168, 110, 10),
												   new Hurtbox(180, 120, 10),
												   new Hurtbox(90, 105, 12),
												   new Hurtbox(90, 83, 12),
												   new Hurtbox(76, 107, 9),
												   new Hurtbox(160, 107, 9),
												   new Hurtbox(100, 40, 30),
												   new Hurtbox(100, 75, 9)};
		
		
		lacerdaBairLeftHitboxes = new Hitbox[] {new Hitbox(190, 125, 17),
											    new Hitbox(210, 125, 17),
											    new Hitbox(230, 125, 17),
											    new Hitbox(250, 125, 17),
											    new Hitbox(270, 125, 17)};
				
		
		lacerdaBairLeftFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.lacerda0BairLeft[0], lacerdaBairLeftHurtboxes0, null, 400, 200),
													  new AttackFrame(2, Assets.lacerda0BairLeft[1], lacerdaBairLeftHurtboxes1, null, 400, 200),
													  new AttackFrame(2, Assets.lacerda0BairLeft[2], lacerdaBairLeftHurtboxes2, null, 400, 200),
													  new AttackFrame(2, Assets.lacerda0BairLeft[3], lacerdaDashLeftHurtboxes0, null, 400, 200),
													  new AttackFrame(3, Assets.lacerda0BairLeft[4], lacerdaBairLeftHurtboxes3, lacerdaBairLeftHitboxes, 400, 200),
													  new AttackFrame(4, Assets.lacerda0BairLeft[3], lacerdaDashLeftHurtboxes0, null, 400, 200),
													  new AttackFrame(6, Assets.lacerda0BairLeft[2], lacerdaBairLeftHurtboxes2, null, 400, 200),
													  new AttackFrame(10, Assets.lacerda0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
								
													 {new AttackFrame(2, Assets.lacerda1BairLeft[0], lacerdaBairLeftHurtboxes0, null, 400, 200),
													  new AttackFrame(2, Assets.lacerda1BairLeft[1], lacerdaBairLeftHurtboxes1, null, 400, 200),
													  new AttackFrame(2, Assets.lacerda1BairLeft[2], lacerdaBairLeftHurtboxes2, null, 400, 200),
													  new AttackFrame(2, Assets.lacerda1BairLeft[3], lacerdaDashLeftHurtboxes0, null, 400, 200),
													  new AttackFrame(3, Assets.lacerda1BairLeft[4], lacerdaBairLeftHurtboxes3, lacerdaBairLeftHitboxes, 400, 200),
													  new AttackFrame(4, Assets.lacerda1BairLeft[3], lacerdaDashLeftHurtboxes0, null, 400, 200),
													  new AttackFrame(6, Assets.lacerda1BairLeft[2], lacerdaBairLeftHurtboxes2, null, 400, 200),
													  new AttackFrame(10, Assets.lacerda1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
			 
		
		lacerdaBairLeft = new Attack[] {new Attack(lacerdaBairLeftFrames[0], 8, lacerdaBairDamage, 15, -10, 7, 25, brunoCollisionbox),
										new Attack(lacerdaBairLeftFrames[1], 8, lacerdaBairDamage, 15, -10, 7, 25, brunoCollisionbox)};
			
		

		
		
		lacerdaFairRightHitboxes0 = new Hitbox[] {new Hitbox(140, 50, 17),
												  new Hitbox(155, 35, 17),
												  new Hitbox(170, 20, 17),
												  new Hitbox(185, 5, 17)};
		
		lacerdaFairRightHitboxes1 = new Hitbox[] {new Hitbox(140, 100, 17),
												  new Hitbox(160, 100, 17),
												  new Hitbox(180, 100, 17),
												  new Hitbox(200, 100, 17),
												  new Hitbox(220, 100, 17),
												  new Hitbox(240, 100, 17)};
		
		lacerdaFairRightHitboxes2 = new Hitbox[] {new Hitbox(145, 140, 17),
												  new Hitbox(160, 155, 17),
												  new Hitbox(175, 170, 17),
												  new Hitbox(190, 185, 17)};
		
		
		lacerdaFairRightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0FairRight[0], lacerdaBairRightHurtboxes0, null, 400, 200),
													   new AttackFrame(3, Assets.lacerda0FairRight[1], lacerdaBairRightHurtboxes0, null, 400, 200),
													   new AttackFrame(2, Assets.lacerda0FairRight[2], brunoDashRightHurtboxes2, lacerdaFairRightHitboxes0, 400, 200),
													   new AttackFrame(2, Assets.lacerda0FairRight[3], brunoDashRightHurtboxes3, lacerdaFairRightHitboxes1, 400, 200),
													   new AttackFrame(2, Assets.lacerda0FairRight[4], brunoDashRightHurtboxes4, lacerdaFairRightHitboxes2, 400, 200),
													   new AttackFrame(15, Assets.lacerda0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
							
													  {new AttackFrame(3, Assets.lacerda1FairRight[0], brunoFairRightHurtboxes, null, 400, 200),
													   new AttackFrame(3, Assets.lacerda1FairRight[1], brunoFairRightHurtboxes, null, 400, 200),
												       new AttackFrame(2, Assets.lacerda1FairRight[2], brunoFairRightHurtboxes, lacerdaFairRightHitboxes0, 400, 200),
												       new AttackFrame(2, Assets.lacerda1FairRight[3], brunoFairRightHurtboxes, lacerdaFairRightHitboxes1, 400, 200),
													   new AttackFrame(2, Assets.lacerda1FairRight[4], brunoFairRightHurtboxes, lacerdaFairRightHitboxes2, 400, 200),
											   	       new AttackFrame(15, Assets.lacerda1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
								  
		lacerdaFairRight = new Attack[] {new Attack(lacerdaFairRightFrames[0], 6, lacerdaFairDamage, 3, 15, 7, 35, brunoCollisionbox),
				   					   	 new Attack(lacerdaFairRightFrames[1], 6, lacerdaFairDamage, 3, 15, 7, 35, brunoCollisionbox)};
		
		
		
		lacerdaFairLeftHitboxes0 = new Hitbox[] {new Hitbox(60, 50, 17),
												 new Hitbox(45, 35, 17),
												 new Hitbox(30, 20, 17),
												 new Hitbox(15, 5, 17)};
		
		lacerdaFairLeftHitboxes1 = new Hitbox[] {new Hitbox(60, 100, 17),
												 new Hitbox(40, 100, 17),
												 new Hitbox(20, 100, 17),
												 new Hitbox(0, 100, 17),
												 new Hitbox(-20, 100, 17),
												 new Hitbox(-40, 100, 17)};
		
		lacerdaFairLeftHitboxes2 = new Hitbox[] {new Hitbox(55, 140, 17),
												 new Hitbox(40, 155, 17),
												 new Hitbox(25, 170, 17),
												 new Hitbox(10, 185, 17)};
		
		
		lacerdaFairLeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0FairLeft[0], lacerdaBairLeftHurtboxes0, null, 400, 200, -200, 0),
													  new AttackFrame(3, Assets.lacerda0FairLeft[1], lacerdaBairLeftHurtboxes0, null, 400, 200, -200, 0),
													  new AttackFrame(2, Assets.lacerda0FairLeft[2], brunoDashLeftHurtboxes2, lacerdaFairLeftHitboxes0, 400, 200, -200, 0),
													  new AttackFrame(2, Assets.lacerda0FairLeft[3], brunoDashLeftHurtboxes3, lacerdaFairLeftHitboxes1, 400, 200, -200, 0),
													  new AttackFrame(2, Assets.lacerda0FairLeft[4], brunoDashLeftHurtboxes4, lacerdaFairLeftHitboxes2, 400, 200, -200, 0),
													  new AttackFrame(15, Assets.lacerda0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
								
													  {new AttackFrame(3, Assets.lacerda1FairLeft[0], lacerdaBairLeftHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(3, Assets.lacerda1FairLeft[1], lacerdaBairLeftHurtboxes0, null, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda1FairLeft[2], brunoDashLeftHurtboxes2, lacerdaFairLeftHitboxes0, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda1FairLeft[3], brunoDashLeftHurtboxes3, lacerdaFairLeftHitboxes1, 400, 200, -200, 0),
													   new AttackFrame(2, Assets.lacerda1FairLeft[4], brunoDashLeftHurtboxes4, lacerdaFairLeftHitboxes2, 400, 200, -200, 0),
													   new AttackFrame(15, Assets.lacerda1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		lacerdaFairLeft = new Attack[] {new Attack(lacerdaFairLeftFrames[0], 6, lacerdaFairDamage, -3, 15, 7, 35, brunoCollisionbox),
				   	 					new Attack(lacerdaFairLeftFrames[1], 6, lacerdaFairDamage, -3, 15, 7, 35, brunoCollisionbox)};
		
		
		lacerdaUpAirRightHitboxes0 = new Hitbox[] {new Hitbox(150, 40, 17),
												   new Hitbox(165, 25, 17),
												   new Hitbox(180, 10, 17),
												   new Hitbox(195, -5, 17)};
		
		lacerdaUpAirRightHitboxes1 = new Hitbox[] {new Hitbox(100, 0, 17),
												   new Hitbox(100, -20, 17),
												   new Hitbox(100, -40, 17),
												   new Hitbox(100, -60, 17),
												   new Hitbox(100, -80, 17),
												   new Hitbox(130, -60, 25),
												   new Hitbox(130, -30, 25),
												   new Hitbox(160, -40, 25),
												   new Hitbox(160, -10, 25)};
		
		lacerdaUpAirRightHitboxes2 = new Hitbox[] {new Hitbox(50, 30, 17),
												   new Hitbox(35, 15, 17),
												   new Hitbox(20, 0, 17),
												   new Hitbox(5, -15, 17),
												   new Hitbox(30, -30, 25),
												   new Hitbox(55, 0, 25)};
		
		lacerdaUpAirRightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0UpAirRight[0], brunoUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda0UpAirRight[1], brunoUpTiltRightHurtboxes1, lacerdaUpAirRightHitboxes0, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda0UpAirRight[2], brunoUpTiltRightHurtboxes2, lacerdaUpAirRightHitboxes1, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda0UpAirRight[3], brunoUpTiltRightHurtboxes3, lacerdaUpAirRightHitboxes2, 200, 400, 0, -200),
													    new AttackFrame(6, Assets.lacerda0UpAirRight[3], brunoUpTiltRightHurtboxes3, null, 200, 400, 0, -200),
													    new AttackFrame(8, Assets.lacerda0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
								
													   {new AttackFrame(3, Assets.lacerda1UpAirRight[0], brunoUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda1UpAirRight[1], brunoUpTiltRightHurtboxes1, lacerdaUpAirRightHitboxes0, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda1UpAirRight[2], brunoUpTiltRightHurtboxes2, lacerdaUpAirRightHitboxes1, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda1UpAirRight[3], brunoUpTiltRightHurtboxes3, lacerdaUpAirRightHitboxes2, 200, 400, 0, -200),
													    new AttackFrame(6, Assets.lacerda1UpAirRight[3], brunoUpTiltRightHurtboxes3, null, 200, 400, 0, -200),
													    new AttackFrame(8, Assets.lacerda1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};
		
		
		lacerdaUpAirRight = new Attack[] {new Attack(lacerdaUpAirRightFrames[0], 6, lacerdaUpAirDamage, 0, -22, 7, 20, brunoCollisionbox),
									      new Attack(lacerdaUpAirRightFrames[1], 6, lacerdaUpAirDamage, 0, -22, 7, 20, brunoCollisionbox)};
		
		
		
		lacerdaUpAirLeftHitboxes0 = new Hitbox[] {new Hitbox(50, 40, 17),
												  new Hitbox(35, 25, 17),
												  new Hitbox(20, 10, 17),
												  new Hitbox(5, -5, 17)};
		
		lacerdaUpAirLeftHitboxes1 = new Hitbox[] {new Hitbox(100, 0, 17),
												  new Hitbox(100, -20, 17),
												  new Hitbox(100, -40, 17),
												  new Hitbox(100, -60, 17),
												  new Hitbox(100, -80, 17),
												  new Hitbox(70, -60, 25),
												  new Hitbox(70, -30, 25),
												  new Hitbox(40, -40, 25),
												  new Hitbox(40, -10, 25)};
		
		lacerdaUpAirLeftHitboxes2 = new Hitbox[] {new Hitbox(150, 30, 17),
												  new Hitbox(165, 15, 17),
												  new Hitbox(180, 0, 17),
												  new Hitbox(195, -15, 17),
												  new Hitbox(170, -30, 25),
												  new Hitbox(145, 0, 25)};
		
		lacerdaUpAirLeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0UpAirLeft[0], brunoUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.lacerda0UpAirLeft[1], brunoUpTiltLeftHurtboxes1, lacerdaUpAirLeftHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.lacerda0UpAirLeft[2], brunoUpTiltLeftHurtboxes2, lacerdaUpAirLeftHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.lacerda0UpAirLeft[3], brunoUpTiltLeftHurtboxes3, lacerdaUpAirLeftHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(6, Assets.lacerda0UpAirLeft[3], brunoUpTiltLeftHurtboxes3, null, 200, 400, 0, -200),
													   new AttackFrame(8, Assets.lacerda0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
								
													   {new AttackFrame(3, Assets.lacerda1UpAirLeft[0], brunoUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda1UpAirLeft[1], brunoUpTiltLeftHurtboxes1, lacerdaUpAirLeftHitboxes0, 200, 400, 0, -200),
													    new AttackFrame(2, Assets.lacerda1UpAirLeft[2], brunoUpTiltLeftHurtboxes2, lacerdaUpAirLeftHitboxes1, 200, 400, 0, -200),
												        new AttackFrame(2, Assets.lacerda1UpAirLeft[3], brunoUpTiltLeftHurtboxes3, lacerdaUpAirLeftHitboxes2, 200, 400, 0, -200),
													    new AttackFrame(6, Assets.lacerda1UpAirLeft[3], brunoUpTiltLeftHurtboxes3, null, 200, 400, 0, -200),
												        new AttackFrame(8, Assets.lacerda1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		
		lacerdaUpAirLeft = new Attack[] {new Attack(lacerdaUpAirLeftFrames[0], 6, lacerdaUpAirDamage, 0, -22, 7, 20, brunoCollisionbox),
			      						 new Attack(lacerdaUpAirLeftFrames[1], 6, lacerdaUpAirDamage, 0, -22, 7, 20, brunoCollisionbox)};
		
		
		
		
		
		
	  lacerdaUpSpecialRightHitboxes = new Hitbox[] {new Hitbox(100, 40, 40),
			  									    new Hitbox(100, 100, 40),
			  									    new Hitbox(100, 160, 40)};
		
		
	   lacerdaUpSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.lacerda0UpSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200),
		   												   new AttackFrame(2, Assets.lacerda0UpSpecialRight[1], brunoFairRightHurtboxes, null, 200, 200),
		   												   new AttackFrame(2, Assets.lacerda0UpSpecialRight[2], brunoFairRightHurtboxes, null, 200, 200),
		   												   new AttackFrame(1, Assets.lacerda0UpSpecialRight[3], brunoFairRightHurtboxes, null, 200, 200),
		   												   new AttackFrame(1, Assets.lacerda0UpSpecialRight[4], brunoFairRightHurtboxes, null, 200, 200),
		   												   new AttackFrame(1, Assets.lacerda0UpSpecialRight[5], brunoFairRightHurtboxes, null, 200, 200),
		   												   new AttackFrame(1, Assets.lacerda0UpSpecialRight[6], brunoFairRightHurtboxes, null, 200, 200),
		   												   new AttackFrame(1, Assets.lacerda0UpSpecialRight[7], null, null, 200, 200),
		   												   new AttackFrame(1, Assets.lacerda0UpSpecialRight[8], null, null, 200, 200),
		   												   new AttackFrame(1, Assets.lacerda0UpSpecialRight[9], null, null, 200, 200),
		   												   new AttackFrame(5, Assets.lacerda0UpSpecialRight[10], brunoFairRightHurtboxes, lacerdaUpSpecialRightHitboxes, 200, 200),
		   												   new AttackFrame(5, Assets.lacerda0UpSpecialRight[11], brunoFairRightHurtboxes, null, 200, 200)},
		   
						    							  {new AttackFrame(2, Assets.lacerda1UpSpecialRight[0], brunoFairRightHurtboxes, null, 200, 200),
			   											   new AttackFrame(2, Assets.lacerda1UpSpecialRight[1], brunoFairRightHurtboxes, null, 200, 200),
			   											   new AttackFrame(2, Assets.lacerda1UpSpecialRight[2], brunoFairRightHurtboxes, null, 200, 200),
			   											   new AttackFrame(1, Assets.lacerda1UpSpecialRight[3], brunoFairRightHurtboxes, null, 200, 200),
			   											   new AttackFrame(1, Assets.lacerda1UpSpecialRight[4], brunoFairRightHurtboxes, null, 200, 200),
			   											   new AttackFrame(1, Assets.lacerda1UpSpecialRight[5], brunoFairRightHurtboxes, null, 200, 200),
			   											   new AttackFrame(1, Assets.lacerda1UpSpecialRight[6], brunoFairRightHurtboxes, null, 200, 200),
			   											   new AttackFrame(1, Assets.lacerda1UpSpecialRight[7], null, null, 200, 200),
			   											   new AttackFrame(1, Assets.lacerda1UpSpecialRight[8], null, null, 200, 200),
			   											   new AttackFrame(1, Assets.lacerda1UpSpecialRight[9], null, null, 200, 200),
			   											   new AttackFrame(5, Assets.lacerda1UpSpecialRight[10], brunoFairRightHurtboxes, lacerdaUpSpecialRightHitboxes, 200, 200),
			   											   new AttackFrame(5, Assets.lacerda1UpSpecialRight[11], brunoFairRightHurtboxes, null, 200, 200)}};
						    
		lacerdaUpSpecialRight = new Attack[] {new Attack(lacerdaUpSpecialRightFrames[0], 12, lacerdaUpSpecialDamage, 3, -10, 7, 30, brunoCollisionbox),
											  new Attack(lacerdaUpSpecialRightFrames[1], 12, lacerdaUpSpecialDamage, 3, -10, 7, 30, brunoCollisionbox)};
		
		
		
		
		lacerdaUpSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.lacerda0UpSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(2, Assets.lacerda0UpSpecialLeft[1], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(2, Assets.lacerda0UpSpecialLeft[2], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(1, Assets.lacerda0UpSpecialLeft[3], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(1, Assets.lacerda0UpSpecialLeft[4], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(1, Assets.lacerda0UpSpecialLeft[5], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(1, Assets.lacerda0UpSpecialLeft[6], brunoFairLeftHurtboxes, null, 200, 200),
														   new AttackFrame(1, Assets.lacerda0UpSpecialLeft[7], null, null, 200, 200),
														   new AttackFrame(1, Assets.lacerda0UpSpecialLeft[8], null, null, 200, 200),
														   new AttackFrame(1, Assets.lacerda0UpSpecialLeft[9], null, null, 200, 200),
														   new AttackFrame(5, Assets.lacerda0UpSpecialLeft[10], brunoFairLeftHurtboxes, lacerdaUpSpecialRightHitboxes, 200, 200),
														   new AttackFrame(5, Assets.lacerda0UpSpecialLeft[11], brunoFairLeftHurtboxes, null, 200, 200)},
										
													       {new AttackFrame(2, Assets.lacerda1UpSpecialLeft[0], brunoFairLeftHurtboxes, null, 200, 200),
														    new AttackFrame(2, Assets.lacerda1UpSpecialLeft[1], brunoFairLeftHurtboxes, null, 200, 200),
														    new AttackFrame(2, Assets.lacerda1UpSpecialLeft[2], brunoFairLeftHurtboxes, null, 200, 200),
													  	    new AttackFrame(1, Assets.lacerda1UpSpecialLeft[3], brunoFairLeftHurtboxes, null, 200, 200),
															new AttackFrame(1, Assets.lacerda1UpSpecialLeft[4], brunoFairLeftHurtboxes, null, 200, 200),
															new AttackFrame(1, Assets.lacerda1UpSpecialLeft[5], brunoFairLeftHurtboxes, null, 200, 200),
														    new AttackFrame(1, Assets.lacerda1UpSpecialLeft[6], brunoFairLeftHurtboxes, null, 200, 200),
															new AttackFrame(1, Assets.lacerda1UpSpecialLeft[7], null, null, 200, 200),
															new AttackFrame(1, Assets.lacerda1UpSpecialLeft[8], null, null, 200, 200),
															new AttackFrame(1, Assets.lacerda1UpSpecialLeft[9], null, null, 200, 200),
															new AttackFrame(5, Assets.lacerda1UpSpecialLeft[10], brunoFairLeftHurtboxes, lacerdaUpSpecialRightHitboxes, 200, 200),
															new AttackFrame(5, Assets.lacerda1UpSpecialLeft[11], brunoFairLeftHurtboxes, null, 200, 200)}};
		
		lacerdaUpSpecialLeft = new Attack[] {new Attack(lacerdaUpSpecialLeftFrames[0], 12, lacerdaUpSpecialDamage, -3, -10, 7, 30, brunoCollisionbox),
											  new Attack(lacerdaUpSpecialLeftFrames[1], 12, lacerdaUpSpecialDamage, -3, -10, 7, 30, brunoCollisionbox)};
		
		
		
		lacerdaSideSpecial1RightHitboxes = new Hitbox[] {new Hitbox(185, 105, 45)};
		
		
		lacerdaSideSpecial1RightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0SideSpecial1Right[0], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial1Right[1], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial1Right[2], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial1Right[3], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial1Right[4], brunoFairRightHurtboxes, lacerdaSideSpecial1RightHitboxes, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial1Right[5], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(13, Assets.lacerda0SideSpecial1Right[6], brunoFairRightHurtboxes, null, 400, 200)},
												
														      {new AttackFrame(3, Assets.lacerda1SideSpecial1Right[0], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial1Right[1], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial1Right[2], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial1Right[3], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial1Right[4], brunoFairRightHurtboxes, lacerdaSideSpecial1RightHitboxes, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial1Right[5], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(13, Assets.lacerda1SideSpecial1Right[6], brunoFairRightHurtboxes, null, 400, 200)}};
					
		lacerdaSideSpecial1Right = new Attack[] {new Attack(lacerdaSideSpecial1RightFrames[0], 7, lacerdaSideSpecial1Damage, 10, -15, 7, 25, brunoCollisionbox),
											     new Attack(lacerdaSideSpecial1RightFrames[1], 7, lacerdaSideSpecial1Damage, 10, -15, 7, 25, brunoCollisionbox)};
		
		
		
		lacerdaSideSpecial1LeftHitboxes = new Hitbox[] {new Hitbox(15, 105, 45)};
		
		
		lacerdaSideSpecial1LeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0SideSpecial1Left[0], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial1Left[1], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial1Left[2], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial1Left[3], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial1Left[4], brunoFairLeftHurtboxes, lacerdaSideSpecial1LeftHitboxes, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial1Left[5], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(13, Assets.lacerda0SideSpecial1Left[6], brunoFairLeftHurtboxes, null, 400, 200, -200, 0)},
												
														     {new AttackFrame(3, Assets.lacerda1SideSpecial1Left[0], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial1Left[1], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial1Left[2], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial1Left[3], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial1Left[4], brunoFairLeftHurtboxes, lacerdaSideSpecial1LeftHitboxes, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial1Left[5], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(13, Assets.lacerda1SideSpecial1Left[6], brunoFairLeftHurtboxes, null, 400, 200, -200, 0)}};
					
		lacerdaSideSpecial1Left = new Attack[] {new Attack(lacerdaSideSpecial1LeftFrames[0], 7, lacerdaSideSpecial1Damage, -10, -15, 7, 25, brunoCollisionbox),
											    new Attack(lacerdaSideSpecial1LeftFrames[1], 7, lacerdaSideSpecial1Damage, -10, -15, 7, 25, brunoCollisionbox)};
		
		
		
		lacerdaSideSpecial2RightHitboxes = new Hitbox[] {new Hitbox(205, 105, 70)};
		
		
		lacerdaSideSpecial2RightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0SideSpecial2Right[0], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial2Right[1], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial2Right[2], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial2Right[3], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial2Right[4], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial2Right[5], brunoFairRightHurtboxes, lacerdaSideSpecial2RightHitboxes, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial2Right[6], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(13, Assets.lacerda0SideSpecial2Right[7], brunoFairRightHurtboxes, null, 400, 200)},
												
														      {new AttackFrame(3, Assets.lacerda1SideSpecial2Right[0], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial2Right[1], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial2Right[2], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial2Right[3], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial2Right[4], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial2Right[5], brunoFairRightHurtboxes, lacerdaSideSpecial2RightHitboxes, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial2Right[6], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(13, Assets.lacerda1SideSpecial2Right[7], brunoFairRightHurtboxes, null, 400, 200)}};
					
		lacerdaSideSpecial2Right = new Attack[] {new Attack(lacerdaSideSpecial2RightFrames[0], 8, lacerdaSideSpecial2Damage, 20, -20, 7, 30, brunoCollisionbox),
											     new Attack(lacerdaSideSpecial2RightFrames[1], 8, lacerdaSideSpecial2Damage, 20, -20, 7, 30, brunoCollisionbox)};
		
		
		
		lacerdaSideSpecial2LeftHitboxes = new Hitbox[] {new Hitbox(-5, 105, 70)};
		
		
		lacerdaSideSpecial2LeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0SideSpecial2Left[0], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial2Left[1], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial2Left[2], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial2Left[3], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial2Left[4], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial2Left[5], brunoFairLeftHurtboxes, lacerdaSideSpecial2LeftHitboxes, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial2Left[6], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(13, Assets.lacerda0SideSpecial2Left[7], brunoFairLeftHurtboxes, null, 400, 200, -200, 0)},
												
														     {new AttackFrame(3, Assets.lacerda1SideSpecial2Left[0], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial2Left[1], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial2Left[2], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial2Left[3], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial2Left[4], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial2Left[5], brunoFairLeftHurtboxes, lacerdaSideSpecial2LeftHitboxes, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial2Left[6], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(13, Assets.lacerda1SideSpecial2Left[7], brunoFairLeftHurtboxes, null, 400, 200, -200, 0)}};
					
		lacerdaSideSpecial2Left = new Attack[] {new Attack(lacerdaSideSpecial2LeftFrames[0], 8, lacerdaSideSpecial2Damage, -20, -20, 7, 30, brunoCollisionbox),
											    new Attack(lacerdaSideSpecial2LeftFrames[1], 8, lacerdaSideSpecial2Damage, -20, -20, 7, 30, brunoCollisionbox)};
		
		
		
		lacerdaSideSpecial3RightHitboxes = new Hitbox[] {new Hitbox(235, 100, 100)};
		
		
		lacerdaSideSpecial3RightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0SideSpecial3Right[0], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[1], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[2], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[3], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[4], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[5], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[6], brunoFairRightHurtboxes, lacerdaSideSpecial3RightHitboxes, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[7], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda0SideSpecial3Right[8], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(13, Assets.lacerda0SideSpecial3Right[9], brunoFairRightHurtboxes, null, 400, 200)},
												
														      {new AttackFrame(3, Assets.lacerda1SideSpecial3Right[0], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[1], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[2], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[3], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[4], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[5], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[6], brunoFairRightHurtboxes, lacerdaSideSpecial3RightHitboxes, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[7], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(1, Assets.lacerda1SideSpecial3Right[8], brunoFairRightHurtboxes, null, 400, 200),
															   new AttackFrame(13, Assets.lacerda1SideSpecial3Right[9], brunoFairRightHurtboxes, null, 400, 200)}};
					
		lacerdaSideSpecial3Right = new Attack[] {new Attack(lacerdaSideSpecial3RightFrames[0], 10, lacerdaSideSpecial3Damage, 25, -25, 7, 35, brunoCollisionbox),
											     new Attack(lacerdaSideSpecial3RightFrames[1], 10, lacerdaSideSpecial3Damage, 25, -25, 7, 35, brunoCollisionbox)};
		
		
		
		lacerdaSideSpecial3LeftHitboxes = new Hitbox[] {new Hitbox(-35, 100, 100)};
		
		
		lacerdaSideSpecial3LeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.lacerda0SideSpecial3Left[0], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[1], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[2], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[3], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[4], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[5], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[6], brunoFairLeftHurtboxes, lacerdaSideSpecial3LeftHitboxes, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[7], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda0SideSpecial3Left[8], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(13, Assets.lacerda0SideSpecial3Left[9], brunoFairLeftHurtboxes, null, 400, 200, -200, 0)},
												
														     {new AttackFrame(3, Assets.lacerda1SideSpecial3Left[0], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[1], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[2], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[3], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[4], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[5], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[6], brunoFairLeftHurtboxes, lacerdaSideSpecial3LeftHitboxes, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[7], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(1, Assets.lacerda1SideSpecial3Left[8], brunoFairLeftHurtboxes, null, 400, 200, -200, 0),
															  new AttackFrame(13, Assets.lacerda1SideSpecial3Left[9], brunoFairLeftHurtboxes, null, 400, 200, -200, 0)}};
					
		lacerdaSideSpecial3Left = new Attack[] {new Attack(lacerdaSideSpecial3LeftFrames[0], 10, lacerdaSideSpecial3Damage, -25, -25, 7, 35, brunoCollisionbox),
											    new Attack(lacerdaSideSpecial3LeftFrames[1], 10, lacerdaSideSpecial3Damage, -25, -25, 7, 35, brunoCollisionbox)};
		
		
		
		
		lacerdaNeutralSpecial1RightHurtboxes = new Hurtbox[] {new Hurtbox(67, 191, 12),
														  	  new Hurtbox(116, 191, 12),
															  new Hurtbox(70, 170, 12),
															  new Hurtbox(116, 170, 12),
															  new Hurtbox(87, 150, 18),
															  new Hurtbox(110, 150, 15),
															  new Hurtbox(87, 130, 15),
															  new Hurtbox(110, 130, 15),
															  new Hurtbox(85, 105, 17),
															  new Hurtbox(85, 82, 12),
															  new Hurtbox(110, 105, 12),
															  new Hurtbox(115, 83, 14),
													 		  new Hurtbox(100, 40, 30),
															  new Hurtbox(100, 75, 9),
															  new Hurtbox(135, 80, 12),
															  new Hurtbox(135, 60, 12),
															  new Hurtbox(140, 40, 12)};
		
		
		lacerdaNeutralSpecial1RightCounterboxes = new Counterbox[] {new Counterbox(67, 191, 12),
															  	    new Counterbox(116, 191, 12),
																    new Counterbox(70, 170, 12),
																    new Counterbox(116, 170, 12),
																    new Counterbox(87, 150, 18),
																    new Counterbox(110, 150, 15),
																    new Counterbox(87, 130, 15),
																    new Counterbox(110, 130, 15),
																    new Counterbox(85, 105, 17),
																    new Counterbox(85, 82, 12),
																    new Counterbox(110, 105, 12),
																    new Counterbox(115, 83, 14),
														 		    new Counterbox(100, 40, 30),
																    new Counterbox(100, 75, 9),
																    new Counterbox(135, 80, 12),
																    new Counterbox(135, 60, 12),
																    new Counterbox(140, 40, 12)};
		
		
		
		lacerdaNeutralSpecial1RightFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.lacerda0NeutralSpecialRight[0], lacerdaNeutralSpecial1RightHurtboxes, null, 200, 200),
															      new AttackFrame(25, Assets.lacerda0NeutralSpecialRight[1], null, lacerdaNeutralSpecial1RightCounterboxes, null, 200, 200),
															      new AttackFrame(30, Assets.lacerda0NeutralSpecialRight[0], lacerdaNeutralSpecial1RightHurtboxes, null, 200, 200)},
			
															     {new AttackFrame(4, Assets.lacerda1NeutralSpecialRight[0], lacerdaNeutralSpecial1RightHurtboxes, null, 200, 200),
															      new AttackFrame(25, Assets.lacerda1NeutralSpecialRight[1], null, lacerdaNeutralSpecial1RightCounterboxes, null, 200, 200),
															      new AttackFrame(30, Assets.lacerda1NeutralSpecialRight[0], lacerdaNeutralSpecial1RightHurtboxes, null, 200, 200)}};
															   
		
		lacerdaNeutralSpecial1Right = new Attack[] {new Attack(lacerdaNeutralSpecial1RightFrames[0], 3, 0, 0, 0, 0, 0, brunoCollisionbox),
												    new Attack(lacerdaNeutralSpecial1RightFrames[1], 3, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		lacerdaNeutralSpecial1LeftHurtboxes = new Hurtbox[] {new Hurtbox(133, 191, 12),
														  	 new Hurtbox(84, 191, 12),
															 new Hurtbox(130, 170, 12),
															 new Hurtbox(84, 170, 12),
															 new Hurtbox(113, 150, 18),
															 new Hurtbox(90, 150, 15),
															 new Hurtbox(113, 130, 15),
															 new Hurtbox(90, 130, 15),
															 new Hurtbox(115, 105, 17),
															 new Hurtbox(115, 82, 12),
															 new Hurtbox(90, 105, 12),
															 new Hurtbox(85, 83, 14),
													 		 new Hurtbox(100, 40, 30),
															 new Hurtbox(100, 75, 9),
															 new Hurtbox(65, 80, 12),
															 new Hurtbox(65, 60, 12),
															 new Hurtbox(60, 40, 12)};
		
		
		lacerdaNeutralSpecial1LeftCounterboxes = new Counterbox[] {new Counterbox(133, 191, 12),
															  	   new Counterbox(84, 191, 12),
																   new Counterbox(130, 170, 12),
																   new Counterbox(84, 170, 12),
																   new Counterbox(113, 150, 18),
																   new Counterbox(90, 150, 15),
																   new Counterbox(113, 130, 15),
																   new Counterbox(90, 130, 15),
																   new Counterbox(115, 105, 17),
																   new Counterbox(115, 82, 12),
																   new Counterbox(90, 105, 12),
																   new Counterbox(85, 83, 14),
														 		   new Counterbox(100, 40, 30),
																   new Counterbox(100, 75, 9),
																   new Counterbox(65, 80, 12),
																   new Counterbox(65, 60, 12),
																   new Counterbox(60, 40, 12)};
		
		
		
		lacerdaNeutralSpecial1LeftFrames = new AttackFrame[][] {{new AttackFrame(4, Assets.lacerda0NeutralSpecialLeft[0], lacerdaNeutralSpecial1LeftHurtboxes, null, 200, 200),
															     new AttackFrame(25, Assets.lacerda0NeutralSpecialLeft[1], null, lacerdaNeutralSpecial1LeftCounterboxes, null, 200, 200),
															     new AttackFrame(30, Assets.lacerda0NeutralSpecialLeft[0], lacerdaNeutralSpecial1LeftHurtboxes, null, 200, 200)},
			
															    {new AttackFrame(4, Assets.lacerda1NeutralSpecialLeft[0], lacerdaNeutralSpecial1LeftHurtboxes, null, 200, 200),
															     new AttackFrame(25, Assets.lacerda1NeutralSpecialLeft[1], null, lacerdaNeutralSpecial1LeftCounterboxes, null, 200, 200),
															     new AttackFrame(30, Assets.lacerda1NeutralSpecialLeft[0], lacerdaNeutralSpecial1LeftHurtboxes, null, 200, 200)}};
															   
		
		lacerdaNeutralSpecial1Left = new Attack[] {new Attack(lacerdaNeutralSpecial1LeftFrames[0], 3, 0, 0, 0, 0, 0, brunoCollisionbox),
												   new Attack(lacerdaNeutralSpecial1LeftFrames[1], 3, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		lacerdaNeutralSpecial2RightHitboxes0 = new Hitbox[] {new Hitbox(40, 20, 20),
															 new Hitbox(20, 0, 20),
															 new Hitbox(0, -20, 20)};
		
		lacerdaNeutralSpecial2RightHitboxes1 = new Hitbox[] {new Hitbox(40, 20, 20),
															 new Hitbox(20, 0, 20),
															 new Hitbox(0, -20, 20),
															 new Hitbox(60, -20, 30),
															 new Hitbox(30, -45, 30),
															 new Hitbox(100, 0, 20),
															 new Hitbox(100, -20, 30),
															 new Hitbox(100, -60, 30),
															 new Hitbox(70, -50, 30)};
		
		lacerdaNeutralSpecial2RightHitboxes2 = new Hitbox[] {new Hitbox(100, -20, 30),
				 											 new Hitbox(100, -60, 30),
				 											 new Hitbox(130, -60, 25),
															 new Hitbox(130, -30, 25),
															 new Hitbox(160, -40, 25),
															 new Hitbox(160, -10, 25),
															 new Hitbox(150, 40, 30),
															 new Hitbox(180, 10, 30),
															 new Hitbox(120, 20, 30)};
		
		lacerdaNeutralSpecial2RightHitboxes3 = new Hitbox[] {new Hitbox(160, 100, 30),
															 new Hitbox(200, 100, 30),
															 new Hitbox(240, 100, 30),
															 new Hitbox(150, 60, 30),
															 new Hitbox(180, 10, 30),
															 new Hitbox(200, 50, 30)};
		
		lacerdaNeutralSpecial2RightHitboxes4 = new Hitbox[] {new Hitbox(160, 100, 30),
															 new Hitbox(200, 100, 30),
															 new Hitbox(240, 100, 30),
															 new Hitbox(160, 155, 30),
															 new Hitbox(190, 185, 30),
															 new Hitbox(200, 150, 30)};
		
		lacerdaNeutralSpecial2RightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0NeutralSpecialRight[1], null, null, 200, 200),
																  new AttackFrame(2, Assets.lacerda0UpAirRight[3], null, lacerdaNeutralSpecial2RightHitboxes0, 200, 400, 0, -200),
															      new AttackFrame(2, Assets.lacerda0UpAirRight[2], null, lacerdaNeutralSpecial2RightHitboxes1, 200, 400, 0, -200),
															      new AttackFrame(2, Assets.lacerda0FairRight[2], null, lacerdaNeutralSpecial2RightHitboxes2, 400, 200),
															      new AttackFrame(2, Assets.lacerda0FairRight[3], null, lacerdaNeutralSpecial2RightHitboxes3, 400, 200),
															      new AttackFrame(5, Assets.lacerda0FairRight[4], null, lacerdaNeutralSpecial2RightHitboxes4, 400, 200)},
													
															     {new AttackFrame(1, Assets.lacerda1NeutralSpecialRight[1], null, null, 200, 200),
																  new AttackFrame(2, Assets.lacerda1UpAirRight[3], null, lacerdaNeutralSpecial2RightHitboxes0, 200, 400, 0, -200),
															      new AttackFrame(2, Assets.lacerda1UpAirRight[2], null, lacerdaNeutralSpecial2RightHitboxes1, 200, 400, 0, -200),
															      new AttackFrame(2, Assets.lacerda1FairRight[2], null, lacerdaNeutralSpecial2RightHitboxes2, 400, 200),
															      new AttackFrame(2, Assets.lacerda1FairRight[3], null, lacerdaNeutralSpecial2RightHitboxes3, 400, 200),
															      new AttackFrame(5, Assets.lacerda1FairRight[4], null, lacerdaNeutralSpecial2RightHitboxes4, 400, 200)}};
				   
		
		lacerdaNeutralSpecial2Right = new Attack[] {new Attack(lacerdaNeutralSpecial2RightFrames[0], 6, 0, 15, -15, 7, 35, brunoCollisionbox),
													new Attack(lacerdaNeutralSpecial2RightFrames[1], 6, 0, 15, -15, 7, 35, brunoCollisionbox)};
		
		
		
		
		lacerdaNeutralSpecial2LeftHitboxes0 = new Hitbox[] {new Hitbox(160, 20, 20),
															new Hitbox(180, 0, 20),
															new Hitbox(200, -20, 20)};
		
		lacerdaNeutralSpecial2LeftHitboxes1 = new Hitbox[] {new Hitbox(160, 20, 20),
															new Hitbox(180, 0, 20),
															new Hitbox(200, -20, 20),
															new Hitbox(140, -20, 30),
															new Hitbox(170, -45, 30),
															new Hitbox(100, 0, 20),
															new Hitbox(100, -20, 30),
															new Hitbox(100, -60, 30),
															new Hitbox(130, -50, 30)};
		
		lacerdaNeutralSpecial2LeftHitboxes2 = new Hitbox[] {new Hitbox(100, -20, 30),
				 											new Hitbox(100, -60, 30),
				 											new Hitbox(70, -60, 25),
															new Hitbox(70, -30, 25),
															new Hitbox(40, -40, 25),
															new Hitbox(40, -10, 25),
															new Hitbox(50, 40, 30),
															new Hitbox(20, 10, 30),
														    new Hitbox(80, 20, 30)};
		
		lacerdaNeutralSpecial2LeftHitboxes3 = new Hitbox[] {new Hitbox(40, 100, 30),
															new Hitbox(0, 100, 30),
															new Hitbox(-40, 100, 30),
															new Hitbox(50, 60, 30),
															new Hitbox(20, 10, 30),
															new Hitbox(20, 50, 30)};
		
		lacerdaNeutralSpecial2LeftHitboxes4 = new Hitbox[] {new Hitbox(40, 100, 30),
															new Hitbox(0, 100, 30),
															new Hitbox(-40, 100, 30),
															new Hitbox(40, 155, 30),
															new Hitbox(10, 185, 30),
															new Hitbox(0, 150, 30)};
		
		lacerdaNeutralSpecial2LeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.lacerda0NeutralSpecialLeft[1], null, null, 200, 200),
																 new AttackFrame(2, Assets.lacerda0UpAirLeft[3], null, lacerdaNeutralSpecial2LeftHitboxes0, 200, 400, 0, -200),
															     new AttackFrame(2, Assets.lacerda0UpAirLeft[2], null, lacerdaNeutralSpecial2LeftHitboxes1, 200, 400, 0, -200),
															     new AttackFrame(2, Assets.lacerda0FairLeft[2], null, lacerdaNeutralSpecial2LeftHitboxes2, 400, 200, -200, 0),
															     new AttackFrame(2, Assets.lacerda0FairLeft[3], null, lacerdaNeutralSpecial2LeftHitboxes3, 400, 200, -200, 0),
															     new AttackFrame(5, Assets.lacerda0FairLeft[4], null, lacerdaNeutralSpecial2LeftHitboxes4, 400, 200, -200, 0)},
													
															     {new AttackFrame(1, Assets.lacerda1NeutralSpecialLeft[1], null, null, 200, 200),
																  new AttackFrame(2, Assets.lacerda1UpAirLeft[3], null, lacerdaNeutralSpecial2LeftHitboxes0, 200, 400, 0, -200),
															      new AttackFrame(2, Assets.lacerda1UpAirLeft[2], null, lacerdaNeutralSpecial2LeftHitboxes1, 200, 400, 0, -200),
														 	      new AttackFrame(2, Assets.lacerda1FairLeft[2], null, lacerdaNeutralSpecial2LeftHitboxes2, 400, 200, -200, 0),
															      new AttackFrame(2, Assets.lacerda1FairLeft[3], null, lacerdaNeutralSpecial2LeftHitboxes3, 400, 200, -200, 0),
															      new AttackFrame(5, Assets.lacerda1FairLeft[4], null, lacerdaNeutralSpecial2LeftHitboxes4, 400, 200, -200, 0)}};
				   
		
		lacerdaNeutralSpecial2Left = new Attack[] {new Attack(lacerdaNeutralSpecial2LeftFrames[0], 6, 0, -15, -15, 7, 35, brunoCollisionbox),
													new Attack(lacerdaNeutralSpecial2LeftFrames[1], 6, 0, -15, -15, 7, 35, brunoCollisionbox)};
		
		
		
		
		//OBINO
		
		obinoShieldingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0ShieldingRight[0], brunoShieldingHurtbox, null, 200, 200)},
			 											 {new AttackFrame(1, Assets.obino1ShieldingRight[0], brunoShieldingHurtbox, null, 200, 200)}};
			 

		obinoShieldingRight = new Attack[] {new Attack(obinoShieldingRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										    new Attack(obinoShieldingRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		obinoShieldHitRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0ShieldHitRight[0], brunoShieldingHurtbox, null, 200, 200)},
					  									 {new AttackFrame(1, Assets.obino1ShieldHitRight[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		obinoShieldHitRight = new Attack[] {new Attack(obinoShieldHitRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										    new Attack(obinoShieldHitRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		obinoShieldingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0ShieldingLeft[0], brunoShieldingHurtbox, null, 200, 200)},
				    							        {new AttackFrame(1, Assets.obino1ShieldingLeft[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		obinoShieldingLeft = new Attack[] {new Attack(obinoShieldingLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(obinoShieldingLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		obinoShieldHitLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0ShieldHitLeft[0], brunoShieldingHurtbox, null, 200, 200)},
													    {new AttackFrame(1, Assets.obino1ShieldHitLeft[0], brunoShieldingHurtbox, null, 200, 200)}};
		
		obinoShieldHitLeft = new Attack[] {new Attack(obinoShieldHitLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(obinoShieldHitLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		obinoParryRightFrames = new AttackFrame[] {new AttackFrame(1, Assets.obino0ParryRight, null, null, 200, 200),
												   new AttackFrame(1, Assets.obino1ParryRight, null, null, 200, 200)};
		
		obinoParryLeftFrames = new AttackFrame[] {new AttackFrame(1, Assets.obino0ParryLeft, null, null, 200, 200),
				   								  new AttackFrame(1, Assets.obino1ParryLeft, null, null, 200, 200)};
		
		
		obinoStandingRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)},
													    {new AttackFrame(1, Assets.obino1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200)}};

		obinoStandingRight = new Attack[] {new Attack(obinoStandingRightFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(obinoStandingRightFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		obinoStandingLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)},
		    										   {new AttackFrame(1, Assets.obino1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200)}};

		obinoStandingLeft = new Attack[] {new Attack(obinoStandingLeftFrames[0], 1, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(obinoStandingLeftFrames[1], 1, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		obinoWalkingRightFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.obino0WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(6, Assets.obino0WalkingRight[1], brunoWalkingRightHurtboxes1, null, 200, 200),
													    new AttackFrame(6, Assets.obino0WalkingRight[2], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(6, Assets.obino0WalkingRight[3], brunoStandingRightHurtboxes, null, 200, 200)},
													
													   {new AttackFrame(6, Assets.obino1WalkingRight[0], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(6, Assets.obino1WalkingRight[1], brunoWalkingRightHurtboxes1, null, 200, 200),
												        new AttackFrame(6, Assets.obino1WalkingRight[2], brunoWalkingRightHurtboxes0, null, 200, 200),
													    new AttackFrame(6, Assets.obino1WalkingRight[3], brunoStandingRightHurtboxes, null, 200, 200)}};

		obinoWalkingRight = new Attack[] {new Attack(obinoWalkingRightFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
										  new Attack(obinoWalkingRightFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		obinoWalkingLeftFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.obino0WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200),
													   new AttackFrame(6, Assets.obino0WalkingLeft[1], brunoWalkingLeftHurtboxes1, null, 200, 200),
													   new AttackFrame(6, Assets.obino0WalkingLeft[2], brunoWalkingLeftHurtboxes0, null, 200, 200),
													   new AttackFrame(6, Assets.obino0WalkingLeft[3], brunoStandingLeftHurtboxes, null, 200, 200)},
													
													  {new AttackFrame(6, Assets.obino1WalkingLeft[0], brunoWalkingLeftHurtboxes0, null, 200, 200),
													   new AttackFrame(6, Assets.obino1WalkingLeft[1], brunoWalkingLeftHurtboxes1, null, 200, 200),
												       new AttackFrame(6, Assets.obino1WalkingLeft[2], brunoWalkingLeftHurtboxes0, null, 200, 200),
													   new AttackFrame(6, Assets.obino1WalkingLeft[3], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		obinoWalkingLeft = new Attack[] {new Attack(obinoWalkingLeftFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
										 new Attack(obinoWalkingLeftFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		obinoJabRightHitboxes = new Hitbox[] {new Hitbox(155, 90, 25),
				  							  new Hitbox(155, 115, 25)};

		obinoJabRightFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.obino0JabRight[0], brunoStandingRightHurtboxes, null, 200, 200),
												    new AttackFrame(2, Assets.obino0JabRight[1], brunoStandingRightHurtboxes, null, 200, 200),
												    new AttackFrame(1, Assets.obino0JabRight[2], brunoStandingRightHurtboxes, null, 200, 200),
												    new AttackFrame(6, Assets.obino0JabRight[3], brunoJabRightHurtboxes2, obinoJabRightHitboxes, 200, 200),
												    new AttackFrame(6, Assets.obino0JabRight[3], brunoJabRightHurtboxes2, null, 200, 200),
												    new AttackFrame(8, Assets.obino0JabRight[4], brunoStandingRightHurtboxes, null, 200, 200)},
													
												   {new AttackFrame(2, Assets.obino1JabRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													new AttackFrame(2, Assets.obino1JabRight[1], brunoStandingRightHurtboxes, null, 200, 200),
											        new AttackFrame(1, Assets.obino1JabRight[2], brunoStandingRightHurtboxes, null, 200, 200),
												    new AttackFrame(6, Assets.obino1JabRight[3], brunoJabRightHurtboxes2, obinoJabRightHitboxes, 200, 200),
												    new AttackFrame(6, Assets.obino1JabRight[3], brunoStandingRightHurtboxes, null, 200, 200),
												    new AttackFrame(8, Assets.obino1JabRight[4], brunoStandingRightHurtboxes, null, 200, 200)}};
		
		obinoJabRight = new Attack[] {new Attack(obinoJabRightFrames[0], 6, obinoJabDamage, 15, -10, 7, 30, brunoCollisionbox),
				  					  new Attack(obinoJabRightFrames[1], 6, obinoJabDamage, 15, -10, 7, 30, brunoCollisionbox)};
		
		
		obinoJabLeftHitboxes = new Hitbox[] {new Hitbox(45, 90, 25),
				  							 new Hitbox(45, 115, 25)};

		obinoJabLeftFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.obino0JabLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(2, Assets.obino0JabLeft[1], brunoStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(1, Assets.obino0JabLeft[2], brunoStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(6, Assets.obino0JabLeft[3], brunoJabLeftHurtboxes2, obinoJabLeftHitboxes, 200, 200),
												   new AttackFrame(6, Assets.obino0JabLeft[3], brunoJabLeftHurtboxes2, null, 200, 200),
												   new AttackFrame(8, Assets.obino0JabLeft[4], brunoStandingLeftHurtboxes, null, 200, 200)},
													
												  {new AttackFrame(2, Assets.obino1JabLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(2, Assets.obino1JabLeft[1], brunoStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(1, Assets.obino1JabLeft[2], brunoStandingLeftHurtboxes, null, 200, 200),
												   new AttackFrame(6, Assets.obino1JabLeft[3], brunoJabLeftHurtboxes2, obinoJabLeftHitboxes, 200, 200),
												   new AttackFrame(6, Assets.obino1JabLeft[3], brunoJabLeftHurtboxes2, null, 200, 200),
												   new AttackFrame(8, Assets.obino1JabLeft[4], brunoStandingLeftHurtboxes, null, 200, 200)}};
		
		obinoJabLeft = new Attack[] {new Attack(obinoJabLeftFrames[0], 6, obinoJabDamage, -15, -10, 7, 30, brunoCollisionbox),
									 new Attack(obinoJabLeftFrames[1], 6, obinoJabDamage, -15, -10, 7, 30, brunoCollisionbox)};
		
		
		
		obinoDashRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
											      new Hurtbox(116, 191, 12),
										          new Hurtbox(70, 170, 12),
											      new Hurtbox(116, 170, 12),
											      new Hurtbox(87, 150, 18),
										          new Hurtbox(110, 150, 15),
										          new Hurtbox(87, 130, 15),
										          new Hurtbox(110, 130, 15),
											      new Hurtbox(85, 107, 18),
											      new Hurtbox(85, 79, 15),
											      new Hurtbox(75, 92, 15),
											      new Hurtbox(55, 88, 10),
											      new Hurtbox(47, 100, 10),
											      new Hurtbox(47, 120, 10),
											      new Hurtbox(110, 105, 12),
											      new Hurtbox(110, 83, 12),
											      new Hurtbox(124, 107, 9),
											      new Hurtbox(140, 107, 9),
											      new Hurtbox(100, 40, 30),
											      new Hurtbox(100, 75, 9)};
		
		obinoDashRightHurtboxes1 = new Hurtbox[] {new Hurtbox(67, 191, 12),
											      new Hurtbox(116, 191, 12),
										          new Hurtbox(70, 170, 12),
											      new Hurtbox(116, 170, 12),
											      new Hurtbox(87, 150, 18),
										          new Hurtbox(110, 150, 15),
										          new Hurtbox(87, 130, 15),
										          new Hurtbox(110, 130, 15),
											      new Hurtbox(85, 107, 18),
											      new Hurtbox(85, 79, 15),
											      new Hurtbox(75, 92, 15),
											      new Hurtbox(60, 88, 10),
											      new Hurtbox(45, 88, 10),
											      new Hurtbox(35, 100, 10),
											      new Hurtbox(22, 110, 10),
											      new Hurtbox(10, 120, 10),
											      new Hurtbox(110, 105, 12),
											      new Hurtbox(110, 83, 12),
											      new Hurtbox(124, 107, 9),
											      new Hurtbox(140, 107, 9),
											      new Hurtbox(100, 40, 30),
											      new Hurtbox(100, 75, 9)};

		
		obinoDashRightHurtboxes2 = new Hurtbox[] {new Hurtbox(75, 191, 12),
												  new Hurtbox(120, 191, 12),
												  new Hurtbox(75, 170, 12),
												  new Hurtbox(116, 170, 12),
												  new Hurtbox(90, 150, 18),
												  new Hurtbox(110, 150, 15),
												  new Hurtbox(90, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(85, 100, 27),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
												  new Hurtbox(128, 120, 9),
												  new Hurtbox(144, 120, 9),
												  new Hurtbox(160, 120, 9),
										 		  new Hurtbox(100, 40, 30),
		  										  new Hurtbox(100, 75, 9)};
		
		
		
		obinoDashRightHitboxes0 = new Hitbox[] {new Hitbox(260, 122, 25),
												new Hitbox(230, 122, 15),
												new Hitbox(210, 122, 15),
												new Hitbox(190, 122, 15),
												new Hitbox(170, 122, 15),
												new Hitbox(150, 122, 15),
												new Hitbox(130, 122, 15)};
		
		obinoDashRightHitboxes1 = new Hitbox[] {new Hitbox(340, 122, 25, true),
												new Hitbox(310, 122, 15),
												new Hitbox(290, 122, 15),
												new Hitbox(270, 122, 15),
												new Hitbox(250, 122, 15),
												new Hitbox(230, 122, 15),
												new Hitbox(210, 122, 15),
												new Hitbox(190, 122, 15)};
		

		obinoDashRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													 new AttackFrame(4, Assets.obino0DashRight[0], obinoDashRightHurtboxes0, null, 400, 200),
												     new AttackFrame(8, Assets.obino0DashRight[1], obinoDashRightHurtboxes1, null, 400, 200),
												     new AttackFrame(2, Assets.obino0DashRight[2], brunoWalkingRightHurtboxes0, obinoDashRightHitboxes0, 400, 200),
												     new AttackFrame(3, Assets.obino0DashRight[3], obinoDashRightHurtboxes2, obinoDashRightHitboxes1, 400, 200),
												     new AttackFrame(10, Assets.obino0DashRight[3], obinoDashRightHurtboxes2, null, 400, 200),
												     new AttackFrame(8, Assets.obino0DashRight[4], brunoWalkingRightHurtboxes0, null, 400, 200),
												     new AttackFrame(7, Assets.obino0DashRight[5], brunoWalkingRightHurtboxes0, null, 400, 200)},
								
													{new AttackFrame(1, Assets.obino1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													 new AttackFrame(4, Assets.obino1DashRight[0], obinoDashRightHurtboxes0, null, 400, 200),
												     new AttackFrame(8, Assets.obino1DashRight[1], obinoDashRightHurtboxes1, null, 400, 200),
												     new AttackFrame(2, Assets.obino1DashRight[2], brunoWalkingRightHurtboxes0, obinoDashRightHitboxes0, 400, 200),
												     new AttackFrame(3, Assets.obino1DashRight[3], obinoDashRightHurtboxes2, obinoDashRightHitboxes1, 400, 200),
												     new AttackFrame(10, Assets.obino1DashRight[3], obinoDashRightHurtboxes2, null, 400, 200),
												     new AttackFrame(8, Assets.obino1DashRight[4], brunoWalkingRightHurtboxes0, null, 400, 200),
												     new AttackFrame(7, Assets.obino1DashRight[5], brunoWalkingRightHurtboxes0, null, 400, 200)}};
		
		obinoDashRight = new Attack[] {new Attack(obinoDashRightFrames[0], 8, obinoDashDamage, 17, -10, 7, 25, brunoCollisionbox, obinoTipperDashDamage, 25, -8),
									   new Attack(obinoDashRightFrames[1], 8, obinoDashDamage, 17, -10, 7, 25, brunoCollisionbox, obinoTipperDashDamage, 25, -8)};
		
		
		
		obinoDashLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
											     new Hurtbox(84, 191, 12),
										         new Hurtbox(130, 170, 12),
											     new Hurtbox(84, 170, 12),
											     new Hurtbox(113, 150, 18),
										         new Hurtbox(90, 150, 15),
										         new Hurtbox(113, 130, 15),
										         new Hurtbox(90, 130, 15),
											     new Hurtbox(115, 107, 18),
											     new Hurtbox(115, 79, 15),
											     new Hurtbox(125, 92, 15),
											     new Hurtbox(145, 88, 10),
											     new Hurtbox(153, 100, 10),
											     new Hurtbox(153, 120, 10),
											     new Hurtbox(90, 105, 12),
											     new Hurtbox(90, 83, 12),
											     new Hurtbox(76, 107, 9),
											     new Hurtbox(60, 107, 9),
											     new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		obinoDashLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(133, 191, 12),
											     new Hurtbox(84, 191, 12),
										         new Hurtbox(130, 170, 12),
											     new Hurtbox(84, 170, 12),
											     new Hurtbox(113, 150, 18),
										         new Hurtbox(90, 150, 15),
										         new Hurtbox(113, 130, 15),
										         new Hurtbox(90, 130, 15),
											     new Hurtbox(115, 107, 18),
											     new Hurtbox(115, 79, 15),
											     new Hurtbox(125, 92, 15),
											     new Hurtbox(140, 88, 10),
											     new Hurtbox(155, 88, 10),
											     new Hurtbox(165, 100, 10),
											     new Hurtbox(178, 110, 10),
											     new Hurtbox(190, 120, 10),
											     new Hurtbox(90, 105, 12),
											     new Hurtbox(90, 83, 12),
											     new Hurtbox(76, 107, 9),
											     new Hurtbox(60, 107, 9),
											     new Hurtbox(100, 40, 30),
											     new Hurtbox(100, 75, 9)};
		
		
		obinoDashLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(125, 191, 12),
												 new Hurtbox(80, 191, 12),
												 new Hurtbox(125, 170, 12),
												 new Hurtbox(84, 170, 12),
												 new Hurtbox(110, 150, 18),
												 new Hurtbox(90, 150, 15),
												 new Hurtbox(110, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(115, 100, 27),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
												 new Hurtbox(72, 120, 9),
												 new Hurtbox(56, 120, 9),
												 new Hurtbox(40, 120, 9),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9)};
		
		
		
		obinoDashLeftHitboxes0 = new Hitbox[] {new Hitbox(-60, 122, 25),
											   new Hitbox(-30, 122, 15),
											   new Hitbox(-10, 122, 15),
											   new Hitbox(10, 122, 15),
											   new Hitbox(30, 122, 15),
											   new Hitbox(50, 122, 15),
											   new Hitbox(70, 122, 15)};
		
		obinoDashLeftHitboxes1 = new Hitbox[] {new Hitbox(-140, 122, 25, true),
											   new Hitbox(-110, 122, 15),
											   new Hitbox(-90, 122, 15),
										       new Hitbox(-70, 122, 15),
											   new Hitbox(-50, 122, 15),
										       new Hitbox(-30, 122, 15),
											   new Hitbox(-10, 122, 15),
											   new Hitbox(10, 122, 15)};
		
		
		obinoDashLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													new AttackFrame(4, Assets.obino0DashLeft[0], obinoDashLeftHurtboxes0, null, 400, 200, -200, 0),
												    new AttackFrame(8, Assets.obino0DashLeft[1], obinoDashLeftHurtboxes1, null, 400, 200, -200, 0),
												    new AttackFrame(2, Assets.obino0DashLeft[2], brunoWalkingLeftHurtboxes0, obinoDashLeftHitboxes0, 400, 200, -200, 0),
												    new AttackFrame(3, Assets.obino0DashLeft[3], obinoDashLeftHurtboxes2, obinoDashLeftHitboxes1, 400, 200, -200, 0),
												    new AttackFrame(10, Assets.obino0DashLeft[3], obinoDashLeftHurtboxes2, null, 400, 200, -200, 0),
												    new AttackFrame(8, Assets.obino0DashLeft[4], brunoWalkingLeftHurtboxes0, null, 400, 200, -200, 0),
												    new AttackFrame(7, Assets.obino0DashLeft[5], brunoWalkingLeftHurtboxes0, null, 400, 200, -200, 0)},
								
												   {new AttackFrame(1, Assets.obino1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													new AttackFrame(4, Assets.obino1DashLeft[0], obinoDashLeftHurtboxes0, null, 400, 200, -200, 0),
												    new AttackFrame(8, Assets.obino1DashLeft[1], obinoDashLeftHurtboxes1, null, 400, 200, -200, 0),
												    new AttackFrame(2, Assets.obino1DashLeft[2], brunoWalkingLeftHurtboxes0, obinoDashLeftHitboxes0, 400, 200, -200, 0),
												    new AttackFrame(3, Assets.obino1DashLeft[3], obinoDashLeftHurtboxes2, obinoDashLeftHitboxes1, 400, 200, -200, 0),
												    new AttackFrame(10, Assets.obino1DashLeft[3], obinoDashLeftHurtboxes2, null, 400, 200, -200, 0),
												    new AttackFrame(8, Assets.obino1DashLeft[4], brunoWalkingLeftHurtboxes0, null, 400, 200, -200, 0),
												    new AttackFrame(7, Assets.obino1DashLeft[5], brunoWalkingLeftHurtboxes0, null, 400, 200, -200, 0)}};
		
		obinoDashLeft = new Attack[] {new Attack(obinoDashLeftFrames[0], 8, obinoDashDamage, -17, -10, 7, 25, brunoCollisionbox, obinoTipperDashDamage, -25, -8),
									  new Attack(obinoDashLeftFrames[1], 8, obinoDashDamage, -17, -10, 7, 25, brunoCollisionbox, obinoTipperDashDamage, -25, -8)};
		
		
		
		obinoUpTiltRightHitboxes0 = new Hitbox[] {new Hitbox(165, 160, 45)};
		
		obinoUpTiltRightHitboxes1 = new Hitbox[] {new Hitbox(165, 160, 45),
												  new Hitbox(165, 90, 45)};
		
		obinoUpTiltRightHitboxes2 = new Hitbox[] {new Hitbox(165, 160, 45),
												  new Hitbox(165, 90, 45),
												  new Hitbox(165, 30, 45),
												  new Hitbox(165, -30, 50)};
		
		
		obinoUpTiltRightFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(20, Assets.obino0UpTiltRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.obino0UpTiltRight[1], brunoStandingRightHurtboxes, obinoUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.obino0UpTiltRight[2], brunoStandingRightHurtboxes, obinoUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.obino0UpTiltRight[3], brunoStandingRightHurtboxes, obinoUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.obino0UpTiltRight[4], brunoStandingRightHurtboxes, null, 200, 400, 0, -200)},
								
													  {new AttackFrame(1, Assets.obino1StandingRight[0], brunoStandingRightHurtboxes, null, 200, 200),
													   new AttackFrame(20, Assets.obino1UpTiltRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 400, 0, -200),
													   new AttackFrame(3, Assets.obino1UpTiltRight[1], brunoStandingRightHurtboxes, obinoUpTiltRightHitboxes0, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.obino1UpTiltRight[2], brunoStandingRightHurtboxes, obinoUpTiltRightHitboxes1, 200, 400, 0, -200),
													   new AttackFrame(5, Assets.obino1UpTiltRight[3], brunoStandingRightHurtboxes, obinoUpTiltRightHitboxes2, 200, 400, 0, -200),
													   new AttackFrame(2, Assets.obino1UpTiltRight[4], brunoStandingRightHurtboxes, null, 200, 400, 0, -200)}};
		
							   
		obinoUpTiltRight = new Attack[] {new Attack(obinoUpTiltRightFrames[0], 6, obinoUpTiltDamage, 3, -42, 10, 45, brunoCollisionbox, 0, 10),
				 						 new Attack(obinoUpTiltRightFrames[1], 6, obinoUpTiltDamage, 3, -42, 10, 45, brunoCollisionbox, 0, 10)};
		
		
		
		obinoUpTiltLeftHitboxes0 = new Hitbox[] {new Hitbox(35, 160, 45)};
		
		obinoUpTiltLeftHitboxes1 = new Hitbox[] {new Hitbox(35, 160, 45),
												 new Hitbox(35, 90, 45)};
		
		obinoUpTiltLeftHitboxes2 = new Hitbox[] {new Hitbox(35, 160, 45),
												 new Hitbox(35, 90, 45),
												 new Hitbox(35, 30, 45),
												 new Hitbox(35, -30, 50)};
		
		
		obinoUpTiltLeftFrames = new AttackFrame[][] {{new AttackFrame(1, Assets.obino0StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(20, Assets.obino0UpTiltLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.obino0UpTiltLeft[1], brunoStandingLeftHurtboxes, obinoUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.obino0UpTiltLeft[2], brunoStandingLeftHurtboxes, obinoUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.obino0UpTiltLeft[3], brunoStandingLeftHurtboxes, obinoUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.obino0UpTiltLeft[4], brunoStandingLeftHurtboxes, null, 200, 400, 0, -200)},
								
													 {new AttackFrame(1, Assets.obino1StandingLeft[0], brunoStandingLeftHurtboxes, null, 200, 200),
													  new AttackFrame(20, Assets.obino1UpTiltLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 400, 0, -200),
													  new AttackFrame(3, Assets.obino1UpTiltLeft[1], brunoStandingLeftHurtboxes, obinoUpTiltLeftHitboxes0, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.obino1UpTiltLeft[2], brunoStandingLeftHurtboxes, obinoUpTiltLeftHitboxes1, 200, 400, 0, -200),
													  new AttackFrame(5, Assets.obino1UpTiltLeft[3], brunoStandingLeftHurtboxes, obinoUpTiltLeftHitboxes2, 200, 400, 0, -200),
													  new AttackFrame(2, Assets.obino1UpTiltLeft[4], brunoStandingLeftHurtboxes, null, 200, 400, 0, -200)}};
		
							   
		obinoUpTiltLeft = new Attack[] {new Attack(obinoUpTiltLeftFrames[0], 6, obinoUpTiltDamage, -3, -42, 10, 45, brunoCollisionbox, 0, 10),
				 						new Attack(obinoUpTiltLeftFrames[1], 6, obinoUpTiltDamage, -3, -42, 10, 45, brunoCollisionbox, 0, 10)};
		
		
		
		
		obinoBairRightHurtboxes0 = new Hurtbox[] {new Hurtbox(87, 155, 18),
												  new Hurtbox(110, 155, 18),
												  new Hurtbox(87, 130, 15),
												  new Hurtbox(110, 130, 15),
												  new Hurtbox(80, 100, 27),
												  new Hurtbox(110, 105, 12),
												  new Hurtbox(110, 83, 12),
												  new Hurtbox(128, 105, 9),
												  new Hurtbox(144, 105, 9),
										 		  new Hurtbox(100, 40, 30),
												  new Hurtbox(100, 75, 9)};
		
		obinoBairRightHurtboxes1 = new Hurtbox[] {new Hurtbox(45, 87, 18),
												  new Hurtbox(45, 110, 18),
												  new Hurtbox(70, 87, 15),
												  new Hurtbox(70, 110, 15),
												  new Hurtbox(100, 80, 27),
												  new Hurtbox(95, 110, 12),
												  new Hurtbox(117, 110, 12),
												  new Hurtbox(95, 128, 9),
												  new Hurtbox(95, 144, 9),
										 		  new Hurtbox(160, 100, 30),
												  new Hurtbox(125, 100, 9)};
		
		
		
		obinoBairRightHitboxes = new Hitbox[] {new Hitbox(20, 100, 40)};
		
		
		obinoBairRightFrames = new AttackFrame[][] {{new AttackFrame(7, Assets.obino0BairRight[0], obinoBairRightHurtboxes0, null, 200, 200),
													 new AttackFrame(3, Assets.obino0BairRight[1], obinoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(2, Assets.obino0BairRight[2], obinoBairRightHurtboxes1, obinoBairRightHitboxes, 200, 200),
													 new AttackFrame(5, Assets.obino0BairRight[2], obinoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(8, Assets.obino0BairRight[1], obinoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(5, Assets.obino0BairRight[0], obinoBairRightHurtboxes0, null, 200, 200)},
								
													{new AttackFrame(7, Assets.obino1BairRight[0], obinoBairRightHurtboxes0, null, 200, 200),
													 new AttackFrame(3, Assets.obino1BairRight[1], obinoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(2, Assets.obino1BairRight[2], obinoBairRightHurtboxes1, obinoBairRightHitboxes, 200, 200),
													 new AttackFrame(5, Assets.obino1BairRight[2], obinoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(8, Assets.obino1BairRight[1], obinoBairRightHurtboxes1, null, 200, 200),
													 new AttackFrame(5, Assets.obino1BairRight[0], obinoBairRightHurtboxes0, null, 200, 200)}};
							 
		
		obinoBairRight = new Attack[] {new Attack(obinoBairRightFrames[0], 6, obinoBairDamage, -25, -12, 7, 30, brunoCollisionbox),
									   new Attack(obinoBairRightFrames[1], 6, obinoBairDamage, -25, -12, 7, 30, brunoCollisionbox)};
		
		
		obinoBairLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(113, 155, 18),
												 new Hurtbox(90, 155, 18),
												 new Hurtbox(113, 130, 15),
												 new Hurtbox(90, 130, 15),
												 new Hurtbox(120, 100, 27),
												 new Hurtbox(90, 105, 12),
												 new Hurtbox(90, 83, 12),
												 new Hurtbox(72, 105, 9),
												 new Hurtbox(56, 105, 9),
										 		 new Hurtbox(100, 40, 30),
												 new Hurtbox(100, 75, 9)};
		
		obinoBairLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(155, 87, 18),
												 new Hurtbox(155, 110, 18),
												 new Hurtbox(130, 87, 15),
												 new Hurtbox(130, 110, 15),
												 new Hurtbox(100, 80, 27),
												 new Hurtbox(105, 110, 12),
												 new Hurtbox(83, 110, 12),
												 new Hurtbox(105, 128, 9),
												 new Hurtbox(105, 144, 9),
										 		 new Hurtbox(40, 100, 30),
												 new Hurtbox(75, 100, 9)};
		
		
		
		obinoBairLeftHitboxes = new Hitbox[] {new Hitbox(180, 100, 40)};
		
		
		obinoBairLeftFrames = new AttackFrame[][] {{new AttackFrame(7, Assets.obino0BairLeft[0], obinoBairLeftHurtboxes0, null, 200, 200),
													new AttackFrame(3, Assets.obino0BairLeft[1], obinoBairLeftHurtboxes1, null, 200, 200),
													new AttackFrame(2, Assets.obino0BairLeft[2], obinoBairLeftHurtboxes1, obinoBairLeftHitboxes, 200, 200),
													new AttackFrame(5, Assets.obino0BairLeft[2], obinoBairLeftHurtboxes1, null, 200, 200),
													new AttackFrame(8, Assets.obino0BairLeft[1], obinoBairLeftHurtboxes1, null, 200, 200),
													new AttackFrame(5, Assets.obino0BairLeft[0], obinoBairLeftHurtboxes0, null, 200, 200)},
								
												   {new AttackFrame(7, Assets.obino1BairLeft[0], obinoBairLeftHurtboxes0, null, 200, 200),
													new AttackFrame(3, Assets.obino1BairLeft[1], obinoBairLeftHurtboxes1, null, 200, 200),
													new AttackFrame(2, Assets.obino1BairLeft[2], obinoBairLeftHurtboxes1, obinoBairLeftHitboxes, 200, 200),
													new AttackFrame(5, Assets.obino1BairLeft[2], obinoBairLeftHurtboxes1, null, 200, 200),
													new AttackFrame(8, Assets.obino1BairLeft[1], obinoBairLeftHurtboxes1, null, 200, 200),
													new AttackFrame(5, Assets.obino1BairLeft[0], obinoBairLeftHurtboxes0, null, 200, 200)}};
		
		
		obinoBairLeft = new Attack[] {new Attack(obinoBairLeftFrames[0], 6, obinoBairDamage, 25, -12, 7, 30, brunoCollisionbox),
									  new Attack(obinoBairLeftFrames[1], 6, obinoBairDamage, 25, -12, 7, 30, brunoCollisionbox)};
		
		
		
		obinoFairRightHitboxes0 = new Hitbox[] {new Hitbox(130, 160, 20),
												new Hitbox(140, 120, 20),
												new Hitbox(185, 160, 45)};
		
		obinoFairRightHitboxes1 = new Hitbox[] {new Hitbox(130, 160, 20),
												new Hitbox(140, 120, 20),
											    new Hitbox(185, 160, 45),
											    new Hitbox(225, 95, 45),
											    new Hitbox(170, 95, 20)};
		
		obinoFairRightHitboxes2 = new Hitbox[] {new Hitbox(130, 160, 20),
												new Hitbox(140, 120, 20),
											    new Hitbox(185, 160, 45),
											    new Hitbox(225, 95, 45),
											    new Hitbox(170, 95, 20),
											    new Hitbox(205, 35, 45),
											    new Hitbox(165, 70, 20)};
		
		
		obinoFairRightFrames = new AttackFrame[][] {{new AttackFrame(15, Assets.obino0FairRight[0], brunoStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(2, Assets.obino0FairRight[1], brunoStandingRightHurtboxes, obinoFairRightHitboxes0, 400, 200),
													 new AttackFrame(2, Assets.obino0FairRight[2], brunoStandingRightHurtboxes, obinoFairRightHitboxes1, 400, 200),
													 new AttackFrame(2, Assets.obino0FairRight[3], brunoStandingRightHurtboxes, obinoFairRightHitboxes2, 400, 200),
													 new AttackFrame(8, Assets.obino0FairRight[4], brunoStandingRightHurtboxes, null, 400, 200)},
								
													{new AttackFrame(15, Assets.obino1FairRight[0], brunoStandingRightHurtboxes, null, 400, 200),
													 new AttackFrame(2, Assets.obino1FairRight[1], brunoStandingRightHurtboxes, obinoFairRightHitboxes0, 400, 200),
													 new AttackFrame(2, Assets.obino1FairRight[2], brunoStandingRightHurtboxes, obinoFairRightHitboxes1, 400, 200),
													 new AttackFrame(2, Assets.obino1FairRight[3], brunoStandingRightHurtboxes, obinoFairRightHitboxes2, 400, 200),
													 new AttackFrame(8, Assets.obino1FairRight[4], brunoStandingRightHurtboxes, null, 400, 200)}};
							 
		obinoFairRight = new Attack[] {new Attack(obinoFairRightFrames[0], 5, obinoFairDamage, 13, -22, 10, 30, brunoCollisionbox),
									   new Attack(obinoFairRightFrames[1], 5, obinoFairDamage, 13, -22, 10, 30, brunoCollisionbox)};
		
		
		
		obinoFairLeftHitboxes0 = new Hitbox[] {new Hitbox(70, 160, 20),
											   new Hitbox(60, 120, 20),
											   new Hitbox(15, 160, 45)};
		
		obinoFairLeftHitboxes1 = new Hitbox[] {new Hitbox(70, 160, 20),
											   new Hitbox(60, 120, 20),
											   new Hitbox(15, 160, 45),
											   new Hitbox(-25, 95, 45),
											   new Hitbox(30, 95, 20)};
							
		obinoFairLeftHitboxes2 = new Hitbox[] {new Hitbox(70, 160, 20),
											   new Hitbox(60, 120, 20),
											   new Hitbox(15, 160, 45),
											   new Hitbox(-25, 95, 45),
											   new Hitbox(30, 95, 20),
											   new Hitbox(-5, 35, 45),
											   new Hitbox(35, 70, 20)};
		
		
		obinoFairLeftFrames = new AttackFrame[][] {{new AttackFrame(15, Assets.obino0FairLeft[0], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
													new AttackFrame(2, Assets.obino0FairLeft[1], brunoStandingLeftHurtboxes, obinoFairLeftHitboxes0, 400, 200, -200, 0),
													new AttackFrame(2, Assets.obino0FairLeft[2], brunoStandingLeftHurtboxes, obinoFairLeftHitboxes1, 400, 200, -200, 0),
													new AttackFrame(2, Assets.obino0FairLeft[3], brunoStandingLeftHurtboxes, obinoFairLeftHitboxes2, 400, 200, -200, 0),
													new AttackFrame(8, Assets.obino0FairLeft[4], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0)},
								
												   {new AttackFrame(15, Assets.obino1FairLeft[0], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
													new AttackFrame(2, Assets.obino1FairLeft[1], brunoStandingLeftHurtboxes, obinoFairLeftHitboxes0, 400, 200, -200, 0),
													new AttackFrame(2, Assets.obino1FairLeft[2], brunoStandingLeftHurtboxes, obinoFairLeftHitboxes1, 400, 200, -200, 0),
													new AttackFrame(2, Assets.obino1FairLeft[3], brunoStandingLeftHurtboxes, obinoFairLeftHitboxes2, 400, 200, -200, 0),
													new AttackFrame(8, Assets.obino1FairLeft[4], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0)}};
		
		obinoFairLeft = new Attack[] {new Attack(obinoFairLeftFrames[0], 5, obinoFairDamage, -13, -22, 10, 25, brunoCollisionbox),
									  new Attack(obinoFairLeftFrames[1], 5, obinoFairDamage, -13, -22, 10, 25, brunoCollisionbox)};
		
		
		
		obinoUpAirRightHurtboxes0 = new Hurtbox[] {new Hurtbox(87, 185, 18),
												   new Hurtbox(110, 185, 18),
												   new Hurtbox(87, 160, 15),
												   new Hurtbox(110, 160, 15),
												   new Hurtbox(80, 130, 27),
												   new Hurtbox(110, 135, 12),
												   new Hurtbox(110, 113, 12),
												   new Hurtbox(128, 135, 9),
												   new Hurtbox(144, 135, 9),
										 		   new Hurtbox(100, 70, 30),
												   new Hurtbox(100, 105, 9)};
		
		obinoUpAirRightHurtboxes1 = new Hurtbox[] {new Hurtbox(80, 191, 12),
											       new Hurtbox(100, 191, 12),
											       new Hurtbox(85, 170, 12),
												   new Hurtbox(105, 170, 12),
												   new Hurtbox(87, 150, 18),
												   new Hurtbox(110, 150, 15),
												   new Hurtbox(87, 130, 15),
												   new Hurtbox(110, 130, 15),
												   new Hurtbox(80, 100, 27),
												   new Hurtbox(110, 105, 12),
												   new Hurtbox(110, 83, 12),
												   new Hurtbox(128, 105, 9),
												   new Hurtbox(144, 105, 9),
												   new Hurtbox(100, 75, 9)};
										
		
		
		obinoUpAirRightHitboxes = new Hitbox[] {new Hitbox(100, 30, 49)};
		
		obinoUpAirRightFrames = new AttackFrame[][] {{new AttackFrame(10, Assets.obino0UpAirRight[0], obinoUpAirRightHurtboxes0, null, 200, 200),
													  new AttackFrame(5, Assets.obino0UpAirRight[1], obinoUpAirRightHurtboxes1, obinoUpAirRightHitboxes, 200, 200),
													  new AttackFrame(10, Assets.obino0UpAirRight[1], brunoWalkingRightHurtboxes0, null, 200, 200)},
								
													 {new AttackFrame(10, Assets.obino1UpAirRight[0], obinoUpAirRightHurtboxes0, null, 200, 200),
													  new AttackFrame(5, Assets.obino1UpAirRight[1], obinoUpAirRightHurtboxes1, obinoUpAirRightHitboxes, 200, 200),
													  new AttackFrame(10, Assets.obino1UpAirRight[1], brunoWalkingRightHurtboxes0, null, 200, 200)}};
								
		
		obinoUpAirRight = new Attack[] {new Attack(obinoUpAirRightFrames[0], 3, obinoUpAirDamage, 0, -30, 7, 35, brunoCollisionbox),
									    new Attack(obinoUpAirRightFrames[1], 3, obinoUpAirDamage, 0, -30, 7, 35, brunoCollisionbox)};
		
		
		obinoUpAirLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(113, 185, 18),
												  new Hurtbox(90, 185, 18),
												  new Hurtbox(113, 160, 15),
												  new Hurtbox(90, 160, 15),
												  new Hurtbox(120, 130, 27),
												  new Hurtbox(90, 135, 12),
												  new Hurtbox(90, 113, 12),
												  new Hurtbox(72, 135, 9),
												  new Hurtbox(56, 135, 9),
										 		  new Hurtbox(100, 70, 30),
												  new Hurtbox(100, 105, 9)};
		
		obinoUpAirLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(120, 191, 12),
											      new Hurtbox(100, 191, 12),
											      new Hurtbox(115, 170, 12),
												  new Hurtbox(95, 170, 12),
												  new Hurtbox(113, 150, 18),
												  new Hurtbox(90, 150, 15),
												  new Hurtbox(113, 130, 15),
												  new Hurtbox(90, 130, 15),
												  new Hurtbox(120, 100, 27),
												  new Hurtbox(90, 105, 12),
												  new Hurtbox(90, 83, 12),
												  new Hurtbox(72, 105, 9),
												  new Hurtbox(56, 105, 9),
												  new Hurtbox(100, 75, 9)};
				
		
		
		obinoUpAirLeftHitboxes = new Hitbox[] {new Hitbox(100, 30, 49)};
		
		obinoUpAirLeftFrames = new AttackFrame[][] {{new AttackFrame(10, Assets.obino0UpAirLeft[0], obinoUpAirLeftHurtboxes0, null, 200, 200),
													 new AttackFrame(5, Assets.obino0UpAirLeft[1], obinoUpAirLeftHurtboxes1, obinoUpAirLeftHitboxes, 200, 200),
													 new AttackFrame(10, Assets.obino0UpAirLeft[1], brunoWalkingLeftHurtboxes0, null, 200, 200)},
								
													{new AttackFrame(10, Assets.obino1UpAirLeft[0], obinoUpAirLeftHurtboxes0, null, 200, 200),
													 new AttackFrame(5, Assets.obino1UpAirLeft[1], obinoUpAirLeftHurtboxes1, obinoUpAirLeftHitboxes, 200, 200),
													 new AttackFrame(10, Assets.obino1UpAirLeft[1], brunoWalkingLeftHurtboxes0, null, 200, 200)}};
								
		
		obinoUpAirLeft = new Attack[] {new Attack(obinoUpAirLeftFrames[0], 3, obinoUpAirDamage, 0, -30, 7, 35, brunoCollisionbox),
			    						new Attack(obinoUpAirLeftFrames[1], 3, obinoUpAirDamage, 0, -30, 7, 35, brunoCollisionbox)};
		
		
		
		
		obinoNeutralSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.obino0NeutralSpecialRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 200),
															   new AttackFrame(6, Assets.obino0NeutralSpecialRight[1], lacerdaUpTiltRightHurtboxes0, null, 200, 200),
															   new AttackFrame(6, Assets.obino0NeutralSpecialRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 200),
															   new AttackFrame(6, Assets.obino0NeutralSpecialRight[1], lacerdaUpTiltRightHurtboxes0, null, 200, 200)},
												
															  {new AttackFrame(6, Assets.obino1NeutralSpecialRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 200),
															   new AttackFrame(6, Assets.obino1NeutralSpecialRight[1], lacerdaUpTiltRightHurtboxes0, null, 200, 200),
															   new AttackFrame(6, Assets.obino1NeutralSpecialRight[0], lacerdaUpTiltRightHurtboxes0, null, 200, 200),
															   new AttackFrame(6, Assets.obino1NeutralSpecialRight[1], lacerdaUpTiltRightHurtboxes0, null, 200, 200)}};
					   
		
		obinoNeutralSpecialRight = new Attack[] {new Attack(obinoNeutralSpecialRightFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
												 new Attack(obinoNeutralSpecialRightFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		obinoNeutralSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(6, Assets.obino0NeutralSpecialLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 200),
															  new AttackFrame(6, Assets.obino0NeutralSpecialLeft[1], lacerdaUpTiltLeftHurtboxes0, null, 200, 200),
															  new AttackFrame(6, Assets.obino0NeutralSpecialLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 200),
															  new AttackFrame(6, Assets.obino0NeutralSpecialLeft[1], lacerdaUpTiltLeftHurtboxes0, null, 200, 200)},
												
															 {new AttackFrame(6, Assets.obino1NeutralSpecialLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 200),
															  new AttackFrame(6, Assets.obino1NeutralSpecialLeft[1], lacerdaUpTiltLeftHurtboxes0, null, 200, 200),
															  new AttackFrame(6, Assets.obino1NeutralSpecialLeft[0], lacerdaUpTiltLeftHurtboxes0, null, 200, 200),
															  new AttackFrame(6, Assets.obino1NeutralSpecialLeft[1], lacerdaUpTiltLeftHurtboxes0, null, 200, 200)}};
		
		
		obinoNeutralSpecialLeft = new Attack[] {new Attack(obinoNeutralSpecialLeftFrames[0], 4, 0, 0, 0, 0, 0, brunoCollisionbox),
												new Attack(obinoNeutralSpecialLeftFrames[1], 4, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		
		obinoSideSpecialRightHitboxes = new Hitbox[] {new Hitbox(385, 95, 15),
													  new Hitbox(365, 95, 15),
													  new Hitbox(345, 95, 15),
													  new Hitbox(325, 95, 15),
													  new Hitbox(305, 95, 15),
													  new Hitbox(285, 95, 15),
													  new Hitbox(265, 95, 15),
													  new Hitbox(245, 95, 15),
													  new Hitbox(225, 95, 15),
													  new Hitbox(205, 95, 15),
													  new Hitbox(185, 95, 15),
													  new Hitbox(165, 95, 15),
													  new Hitbox(145, 95, 15)};
		
		
		
		obinoSideSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.obino0SideSpecialRight[0], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(9, Assets.obino0SideSpecialRight[1], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(2, Assets.obino0SideSpecialRight[2], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(2, Assets.obino0SideSpecialRight[3], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(2, Assets.obino0SideSpecialRight[4], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(10, Assets.obino0SideSpecialRight[5], brunoStandingRightHurtboxes, obinoSideSpecialRightHitboxes, 400, 200),
															new AttackFrame(2, Assets.obino0SideSpecialRight[6], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(2, Assets.obino0SideSpecialRight[7], brunoStandingRightHurtboxes, null, 400, 200)},
												
														   {new AttackFrame(3, Assets.obino1SideSpecialRight[0], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(9, Assets.obino1SideSpecialRight[1], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(2, Assets.obino1SideSpecialRight[2], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(2, Assets.obino1SideSpecialRight[3], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(2, Assets.obino1SideSpecialRight[4], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(10, Assets.obino1SideSpecialRight[5], brunoStandingRightHurtboxes, obinoSideSpecialRightHitboxes, 400, 200),
															new AttackFrame(3, Assets.obino1SideSpecialRight[6], brunoStandingRightHurtboxes, null, 400, 200),
															new AttackFrame(5, Assets.obino1SideSpecialRight[7], brunoStandingRightHurtboxes, null, 400, 200)}};
		
		obinoSideSpecialRight = new Attack[] {new Attack(obinoSideSpecialRightFrames[0], 8, 0, -15, -1, 10, 60, brunoCollisionbox),
											  new Attack(obinoSideSpecialRightFrames[1], 8, 0, -15, -1, 10, 60, brunoCollisionbox)};
		
		
		obinoSideSpecialLeftHitboxes = new Hitbox[] {new Hitbox(-185, 95, 15),
													 new Hitbox(-165, 95, 15),
													 new Hitbox(-145, 95, 15),
													 new Hitbox(-125, 95, 15),
													 new Hitbox(-105, 95, 15),
													 new Hitbox(-85, 95, 15),
													 new Hitbox(-65, 95, 15),
													 new Hitbox(-45, 95, 15),
													 new Hitbox(-25, 95, 15),
													 new Hitbox(-5, 95, 15),
													 new Hitbox(15, 95, 15),
													 new Hitbox(35, 95, 15),
													 new Hitbox(55, 95, 15)};
		
		
		obinoSideSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(3, Assets.obino0SideSpecialLeft[0], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(9, Assets.obino0SideSpecialLeft[1], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino0SideSpecialLeft[2], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino0SideSpecialLeft[3], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino0SideSpecialLeft[4], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(10, Assets.obino0SideSpecialLeft[5], brunoStandingLeftHurtboxes, obinoSideSpecialLeftHitboxes, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino0SideSpecialLeft[6], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino0SideSpecialLeft[7], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0)},
												
														  {new AttackFrame(3, Assets.obino1SideSpecialLeft[0], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(9, Assets.obino1SideSpecialLeft[1], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino1SideSpecialLeft[2], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino1SideSpecialLeft[3], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino1SideSpecialLeft[4], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(10, Assets.obino1SideSpecialLeft[5], brunoStandingLeftHurtboxes, obinoSideSpecialLeftHitboxes, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino1SideSpecialLeft[6], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0),
														   new AttackFrame(2, Assets.obino1SideSpecialLeft[7], brunoStandingLeftHurtboxes, null, 400, 200, -200, 0)}};
												
		obinoSideSpecialLeft = new Attack[] {new Attack(obinoSideSpecialLeftFrames[0], 8, 0, 15, -1, 10, 60, brunoCollisionbox),
											 new Attack(obinoSideSpecialLeftFrames[1], 8, 0, 15, -1, 10, 60, brunoCollisionbox)};
		
		
		
		
		
		
		obinoUpSpecialRightHurtboxes0 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													   new Hurtbox(116, 191, 12),
													   new Hurtbox(70, 170, 12),
											    	   new Hurtbox(116, 170, 12),
													   new Hurtbox(87, 150, 18),
													   new Hurtbox(110, 150, 15),
													   new Hurtbox(87, 130, 15),
													   new Hurtbox(110, 130, 15),
													   new Hurtbox(80, 100, 27),
													   new Hurtbox(110, 105, 12),
													   new Hurtbox(110, 83, 12),
												 	   new Hurtbox(100, 40, 30),
													   new Hurtbox(100, 75, 9),
													   new Hurtbox(120, 70, 9),
													   new Hurtbox(75, 70, 9),
													   new Hurtbox(85, 0, 15),
													   new Hurtbox(130, 0, 15)};
		
		obinoUpSpecialRightHurtboxes1 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													   new Hurtbox(116, 191, 12),
													   new Hurtbox(70, 170, 12),
											    	   new Hurtbox(116, 170, 12),
													   new Hurtbox(87, 150, 18),
													   new Hurtbox(110, 150, 15),
													   new Hurtbox(87, 130, 15),
													   new Hurtbox(110, 130, 15),
													   new Hurtbox(80, 100, 27),
													   new Hurtbox(110, 105, 12),
													   new Hurtbox(110, 83, 12),
												 	   new Hurtbox(100, 40, 30),
													   new Hurtbox(100, 75, 9),
													   new Hurtbox(120, 70, 9),
													   new Hurtbox(75, 70, 9),
													   new Hurtbox(125, 60, 9),
													   new Hurtbox(140, 50, 9),
													   new Hurtbox(150, 35, 9),
													   new Hurtbox(165, 25, 9)};
		
		obinoUpSpecialRightHurtboxes2 = new Hurtbox[] {new Hurtbox(67, 191, 12),
													   new Hurtbox(116, 191, 12),
													   new Hurtbox(70, 170, 12),
													   new Hurtbox(116, 170, 12),
													   new Hurtbox(87, 150, 18),
													   new Hurtbox(110, 150, 15),
													   new Hurtbox(87, 130, 15),
													   new Hurtbox(110, 130, 15),
													   new Hurtbox(80, 100, 27),
													   new Hurtbox(110, 105, 12),
													   new Hurtbox(110, 83, 12),
												 	   new Hurtbox(100, 40, 30),
													   new Hurtbox(100, 75, 9),
													   new Hurtbox(128, 95, 9),
													   new Hurtbox(144, 95, 9),
													   new Hurtbox(160, 95, 9),
													   new Hurtbox(128, 75, 9),
													   new Hurtbox(144, 75, 9),
													   new Hurtbox(160, 75, 9),
													   new Hurtbox(176, 75, 9)};
		
		
	    obinoUpSpecialRightFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.obino0UpSpecialRight[0], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
	    												  new AttackFrame(2, Assets.obino0UpSpecialRight[1], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
	    												  new AttackFrame(2, Assets.obino0UpSpecialRight[2], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
	    												  new AttackFrame(2, Assets.obino0UpSpecialRight[3], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
	    												  new AttackFrame(2, Assets.obino0UpSpecialRight[4], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
	    												  new AttackFrame(3, Assets.obino0UpSpecialRight[5], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
	    												  new AttackFrame(5, Assets.obino0UpSpecialRight[6], obinoUpSpecialRightHurtboxes1, null, 200, 400, 0, -200),
	    												  new AttackFrame(10, Assets.obino0UpSpecialRight[7], obinoUpSpecialRightHurtboxes2, null, 200, 400, 0, -200)},
				
		   												 {new AttackFrame(2, Assets.obino1UpSpecialRight[0], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
		    											  new AttackFrame(2, Assets.obino1UpSpecialRight[1], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
		    											  new AttackFrame(2, Assets.obino1UpSpecialRight[2], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
		    											  new AttackFrame(2, Assets.obino1UpSpecialRight[3], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
		    											  new AttackFrame(2, Assets.obino1UpSpecialRight[4], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
		    											  new AttackFrame(3, Assets.obino1UpSpecialRight[5], obinoUpSpecialRightHurtboxes0, null, 200, 400, 0, -200),
		    											  new AttackFrame(5, Assets.obino1UpSpecialRight[6], obinoUpSpecialRightHurtboxes1, null, 200, 400, 0, -200),
		    											  new AttackFrame(10, Assets.obino1UpSpecialRight[7], obinoUpSpecialRightHurtboxes2, null, 200, 400, 0, -200)}};
						    
		obinoUpSpecialRight = new Attack[] {new Attack(obinoUpSpecialRightFrames[0], 8, 0, 0, 0, 0, 0, brunoCollisionbox),
											new Attack(obinoUpSpecialRightFrames[1], 8, 0, 0, 0, 0, 0, brunoCollisionbox)};
		
		
		
		obinoUpSpecialLeftHurtboxes0 = new Hurtbox[] {new Hurtbox(133, 191, 12),
													  new Hurtbox(84, 191, 12),
													  new Hurtbox(130, 170, 12),
											    	  new Hurtbox(84, 170, 12),
													  new Hurtbox(113, 150, 18),
													  new Hurtbox(90, 150, 15),
													  new Hurtbox(113, 130, 15),
													  new Hurtbox(90, 130, 15),
													  new Hurtbox(120, 100, 27),
													  new Hurtbox(90, 105, 12),
													  new Hurtbox(90, 83, 12),
												 	  new Hurtbox(100, 40, 30),
													  new Hurtbox(100, 75, 9),
													  new Hurtbox(80, 70, 9),
													  new Hurtbox(125, 70, 9),
													  new Hurtbox(115, 0, 15),
													  new Hurtbox(70, 0, 15)};
		
		obinoUpSpecialLeftHurtboxes1 = new Hurtbox[] {new Hurtbox(133, 191, 12),
													  new Hurtbox(84, 191, 12),
													  new Hurtbox(130, 170, 12),
											    	  new Hurtbox(84, 170, 12),
													  new Hurtbox(113, 150, 18),
													  new Hurtbox(90, 150, 15),
													  new Hurtbox(113, 130, 15),
													  new Hurtbox(90, 130, 15),
													  new Hurtbox(120, 100, 27),
													  new Hurtbox(90, 105, 12),
													  new Hurtbox(90, 83, 12),
												 	  new Hurtbox(100, 40, 30),
													  new Hurtbox(100, 75, 9),
													  new Hurtbox(80, 70, 9),
													  new Hurtbox(125, 70, 9),
													  new Hurtbox(75, 60, 9),
													  new Hurtbox(60, 50, 9),
													  new Hurtbox(50, 35, 9),
													  new Hurtbox(35, 25, 9)};
		
		obinoUpSpecialLeftHurtboxes2 = new Hurtbox[] {new Hurtbox(133, 191, 12),
													  new Hurtbox(84, 191, 12),
													  new Hurtbox(130, 170, 12),
													  new Hurtbox(84, 170, 12),
													  new Hurtbox(113, 150, 18),
													  new Hurtbox(90, 150, 15),
													  new Hurtbox(113, 130, 15),
													  new Hurtbox(90, 130, 15),
													  new Hurtbox(120, 100, 27),
													  new Hurtbox(90, 105, 12),
													  new Hurtbox(90, 83, 12),
												 	  new Hurtbox(100, 40, 30),
													  new Hurtbox(100, 75, 9),
													  new Hurtbox(72, 95, 9),
													  new Hurtbox(56, 95, 9),
													  new Hurtbox(40, 95, 9),
													  new Hurtbox(72, 75, 9),
													  new Hurtbox(56, 75, 9),
													  new Hurtbox(40, 75, 9),
													  new Hurtbox(24, 75, 9)};
		
		
		obinoUpSpecialLeftFrames = new AttackFrame[][] {{new AttackFrame(2, Assets.obino0UpSpecialLeft[0], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino0UpSpecialLeft[1], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino0UpSpecialLeft[2], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino0UpSpecialLeft[3], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino0UpSpecialLeft[4], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.obino0UpSpecialLeft[5], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(5, Assets.obino0UpSpecialLeft[6], obinoUpSpecialLeftHurtboxes1, null, 200, 400, 0, -200),
														 new AttackFrame(10, Assets.obino0UpSpecialLeft[7], obinoUpSpecialLeftHurtboxes2, null, 200, 400, 0, -200)},
									
														{new AttackFrame(2, Assets.obino1UpSpecialLeft[0], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino1UpSpecialLeft[1], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino1UpSpecialLeft[2], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino1UpSpecialLeft[3], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(2, Assets.obino1UpSpecialLeft[4], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(3, Assets.obino1UpSpecialLeft[5], obinoUpSpecialLeftHurtboxes0, null, 200, 400, 0, -200),
														 new AttackFrame(5, Assets.obino1UpSpecialLeft[6], obinoUpSpecialLeftHurtboxes1, null, 200, 400, 0, -200),
														 new AttackFrame(10, Assets.obino1UpSpecialLeft[7], obinoUpSpecialLeftHurtboxes2, null, 200, 400, 0, -200)}};
									
		obinoUpSpecialLeft = new Attack[] {new Attack(obinoUpSpecialLeftFrames[0], 8, 0, 0, 0, 0, 0, brunoCollisionbox),
										   new Attack(obinoUpSpecialLeftFrames[1], 8, 0, 0, 0, 0, 0, brunoCollisionbox)};
		

	}
	
	
	
	
	public static Attack getBrunoStandingRight(int skin) {
		
		return brunoStandingRight[skin];
	}
	
	public static Attack getBrunoStandingLeft(int skin) {
		
		return brunoStandingLeft[skin];
	}
	
	public static Attack getBrunoWalkingRight(int skin) {
		
		return brunoWalkingRight[skin];
	}
	
	public static Attack getBrunoWalkingLeft(int skin) {
		
		return brunoWalkingLeft[skin];
	}
	
	public static Attack getBrunoJabRight(int skin) {
		
		return brunoJabRight[skin];
	}
	
	public static Attack getBrunoJabLeft(int skin) {
		
		return brunoJabLeft[skin];
	}
	
	public static Attack getBrunoDashRight(int skin) {
		
		return brunoDashRight[skin];
	}
	
	public static Attack getBrunoDashLeft(int skin) {
		
		return brunoDashLeft[skin];
	}
	
	public static Attack getBrunoUpTiltRight(int skin) {
		
		return brunoUpTiltRight[skin];
	}
	
	public static Attack getBrunoUpTiltLeft(int skin) {
		
		return brunoUpTiltLeft[skin];
	}
	
	public static Attack getBrunoBairRight(int skin) {
		
		return brunoBairRight[skin];
	}
	
	public static Attack getBrunoBairLeft(int skin) {
		
		return brunoBairLeft[skin];
	}
	
	public static Attack getBrunoFairRight(int skin) {
		
		return brunoFairRight[skin];
	}
	
	public static Attack getBrunoFairLeft(int skin) {
		
		return brunoFairLeft[skin];
	}
	
	public static Attack getBrunoUpAirRight(int skin) {
		
		return brunoUpAirRight[skin];
	}
	
	public static Attack getBrunoUpAirLeft(int skin) {
		
		return brunoUpAirLeft[skin];
	}
	
	public static Attack getBrunoSideSpecialRight(int skin) {
		
		return brunoSideSpecialRight[skin];
	}
	
	public static Attack getBrunoSideSpecialLeft(int skin) {
		
		return brunoSideSpecialLeft[skin];
	}
	
	public static Attack getBrunoNeutralSpecialRight(int skin) {
		
		return brunoNeutralSpecialRight[skin];
	}
	
	public static Attack getBrunoNeutralSpecialLeft(int skin) {
		
		return brunoNeutralSpecialLeft[skin];
	}
	
	public static Attack getBrunoUpSpecialRight(int skin) {
		
		return brunoUpSpecialRight[skin];
	}
	
	public static Attack getBrunoUpSpecialLeft(int skin) {
		
		return brunoUpSpecialLeft[skin];
	}
	
	public static Attack getBrunoShieldingRight(int skin) {
		
		return brunoShieldingRight[skin];
	}
	
	public static Attack getBrunoShieldHitRight(int skin) {
		
		return brunoShieldHitRight[skin];
	}
	
	public static Attack getBrunoShieldingLeft(int skin) {
		
		return brunoShieldingLeft[skin];
	}
	
	public static Attack getBrunoShieldHitLeft(int skin) {
		
		return brunoShieldHitLeft[skin];
	}
	
	public static AttackFrame getBrunoParryRightFrames(int skin) {
		
		return brunoParryRightFrames[skin];
	}
	
	public static AttackFrame getBrunoParryLeftFrames(int skin) {
		
		return brunoParryLeftFrames[skin];
	}
	
	
	
	
	public static Attack getCarolStandingRight(int skin) {
		
		return carolStandingRight[skin];
	}
	
	public static Attack getCarolStandingLeft(int skin) {
		
		return carolStandingLeft[skin];
	}
	
	public static Attack getCarolWalkingRight(int skin) {
		
		return carolWalkingRight[skin];
	}
	
	public static Attack getCarolWalkingLeft(int skin) {
		
		return carolWalkingLeft[skin];
	}
	
	public static Attack getCarolJabRight(int skin) {
		
		return carolJabRight[skin];
	}
	
	public static Attack getCarolJabLeft(int skin) {
		
		return carolJabLeft[skin];
	}
	
	public static Attack getCarolDashRight(int skin) {
		
		return carolDashRight[skin];
	}
	
	public static Attack getCarolDashLeft(int skin) {
		
		return carolDashLeft[skin];
	}
	
	public static Attack getCarolUpTiltRight(int skin) {
		
		return carolUpTiltRight[skin];
	}
	
	public static Attack getCarolUpTiltLeft(int skin) {
		
		return carolUpTiltLeft[skin];
	}
	
	public static Attack getCarolBairRight(int skin) {
		
		return carolBairRight[skin];
	}
	
	public static Attack getCarolBairLeft(int skin) {
		
		return carolBairLeft[skin];
	}
	
	public static Attack getCarolFairRight(int skin) {
		
		return carolFairRight[skin];
	}
	
	public static Attack getCarolFairLeft(int skin) {
		
		return carolFairLeft[skin];
	}
	
	public static Attack getCarolUpAirRight(int skin) {
		
		return carolUpAirRight[skin];
	}
	
	public static Attack getCarolUpAirLeft(int skin) {
		
		return carolUpAirLeft[skin];
	}
	
	public static Attack getCarolSideSpecialRight(int skin) {
		
		return carolSideSpecialRight[skin];
	}
	
	public static Attack getCarolSideSpecialLeft(int skin) {
		
		return carolSideSpecialLeft[skin];
	}
	
	public static Attack getCarolNeutralSpecialRight(int skin) {
		
		return carolNeutralSpecialRight[skin];
	}
	
	public static Attack getCarolNeutralSpecialLeft(int skin) {
		
		return carolNeutralSpecialLeft[skin];
	}
	
	public static Attack getCarolUpSpecialRight(int skin) {
		
		return carolUpSpecialRight[skin];
	}
	
	public static Attack getCarolUpSpecialLeft(int skin) {
		
		return carolUpSpecialLeft[skin];
	}
	
	public static Attack getCarolShieldingRight(int skin) {
		
		return carolShieldingRight[skin];
	}
	
	public static Attack getCarolShieldHitRight(int skin) {
		
		return carolShieldHitRight[skin];
	}
	
	public static Attack getCarolShieldingLeft(int skin) {
		
		return carolShieldingLeft[skin];
	}
	
	public static Attack getCarolShieldHitLeft(int skin) {
		
		return carolShieldHitLeft[skin];
	}
	
	public static AttackFrame getCarolParryRightFrames(int skin) {
		
		return carolParryRightFrames[skin];
	}
	
	public static AttackFrame getCarolParryLeftFrames(int skin) {
		
		return carolParryLeftFrames[skin];
	}
	
	
	
	
	public static Attack getLacerdaStandingRight(int skin) {
		
		return lacerdaStandingRight[skin];
	}
	
	public static Attack getLacerdaStandingLeft(int skin) {
		
		return lacerdaStandingLeft[skin];
	}
	
	public static Attack getLacerdaWalkingRight(int skin) {
		
		return lacerdaWalkingRight[skin];
	}
	
	public static Attack getLacerdaWalkingLeft(int skin) {
		
		return lacerdaWalkingLeft[skin];
	}
	
	public static Attack getLacerdaJabRight(int skin) {
		
		return lacerdaJabRight[skin];
	}
	
	public static Attack getLacerdaJabLeft(int skin) {
		
		return lacerdaJabLeft[skin];
	}
	
	public static Attack getLacerdaDashRight(int skin) {
		
		return lacerdaDashRight[skin];
	}
	
	public static Attack getLacerdaDashLeft(int skin) {
		
		return lacerdaDashLeft[skin];
	}
	
	public static Attack getLacerdaUpTiltRight(int skin) {
		
		return lacerdaUpTiltRight[skin];
	}
	
	public static Attack getLacerdaUpTiltLeft(int skin) {
		
		return lacerdaUpTiltLeft[skin];
	}
	
	public static Attack getLacerdaBairRight(int skin) {
		
		return lacerdaBairRight[skin];
	}
	
	public static Attack getLacerdaBairLeft(int skin) {
		
		return lacerdaBairLeft[skin];
	}
	
	public static Attack getLacerdaFairRight(int skin) {
		
		return lacerdaFairRight[skin];
	}
	
	public static Attack getLacerdaFairLeft(int skin) {
		
		return lacerdaFairLeft[skin];
	}
	
	public static Attack getLacerdaUpAirRight(int skin) {
		
		return lacerdaUpAirRight[skin];
	}
	
	public static Attack getLacerdaUpAirLeft(int skin) {
		
		return lacerdaUpAirLeft[skin];
	}
	
	public static Attack getLacerdaSideSpecial1Right(int skin) {
		
		return lacerdaSideSpecial1Right[skin];
	}
	
	public static Attack getLacerdaSideSpecial1Left(int skin) {
		
		return lacerdaSideSpecial1Left[skin];
	}
	
	public static Attack getLacerdaSideSpecial2Right(int skin) {
		
		return lacerdaSideSpecial2Right[skin];
	}
	
	public static Attack getLacerdaSideSpecial2Left(int skin) {
		
		return lacerdaSideSpecial2Left[skin];
	}
	
	public static Attack getLacerdaSideSpecial3Right(int skin) {
		
		return lacerdaSideSpecial3Right[skin];
	}
	
	public static Attack getLacerdaSideSpecial3Left(int skin) {
		
		return lacerdaSideSpecial3Left[skin];
	}
	
	public static Attack getLacerdaNeutralSpecial1Right(int skin) {
		
		return lacerdaNeutralSpecial1Right[skin];
	}
	
	public static Attack getLacerdaNeutralSpecial1Left(int skin) {
		
		return lacerdaNeutralSpecial1Left[skin];
	}
	
	public static Attack getLacerdaNeutralSpecial2Right(int skin) {
		
		return lacerdaNeutralSpecial2Right[skin];
	}
	
	public static Attack getLacerdaNeutralSpecial2Left(int skin) {
		
		return lacerdaNeutralSpecial2Left[skin];
	}
	
	public static Attack getLacerdaUpSpecialRight(int skin) {
		
		return lacerdaUpSpecialRight[skin];
	}
	
	public static Attack getLacerdaUpSpecialLeft(int skin) {
		
		return lacerdaUpSpecialLeft[skin];
	}
	
	public static Attack getLacerdaShieldingRight(int skin) {
		
		return lacerdaShieldingRight[skin];
	}
	
	public static Attack getLacerdaShieldHitRight(int skin) {
		
		return lacerdaShieldHitRight[skin];
	}
	
	public static Attack getLacerdaShieldingLeft(int skin) {
		
		return lacerdaShieldingLeft[skin];
	}
	
	public static Attack getLacerdaShieldHitLeft(int skin) {
		
		return lacerdaShieldHitLeft[skin];
	}
	
	public static AttackFrame getLacerdaParryRightFrames(int skin) {
		
		return lacerdaParryRightFrames[skin];
	}
	
	public static AttackFrame getLacerdaParryLeftFrames(int skin) {
		
		return lacerdaParryLeftFrames[skin];
	}
	
	
	
	public static Attack getObinoStandingRight(int skin) {
		
		return obinoStandingRight[skin];
	}
	
	public static Attack getObinoStandingLeft(int skin) {
		
		return obinoStandingLeft[skin];
	}
	
	public static Attack getObinoWalkingRight(int skin) {
		
		return obinoWalkingRight[skin];
	}
	
	public static Attack getObinoWalkingLeft(int skin) {
		
		return obinoWalkingLeft[skin];
	}
	
	public static Attack getObinoJabRight(int skin) {
		
		return obinoJabRight[skin];
	}
	
	public static Attack getObinoJabLeft(int skin) {
		
		return obinoJabLeft[skin];
	}
	
	public static Attack getObinoDashRight(int skin) {
		
		return obinoDashRight[skin];
	}
	
	public static Attack getObinoDashLeft(int skin) {
		
		return obinoDashLeft[skin];
	}
	
	public static Attack getObinoUpTiltRight(int skin) {
		
		return obinoUpTiltRight[skin];
	}
	
	public static Attack getObinoUpTiltLeft(int skin) {
		
		return obinoUpTiltLeft[skin];
	}
	
	public static Attack getObinoBairRight(int skin) {
		
		return obinoBairRight[skin];
	}
	
	public static Attack getObinoBairLeft(int skin) {
		
		return obinoBairLeft[skin];
	}
	
	public static Attack getObinoFairRight(int skin) {
		
		return obinoFairRight[skin];
	}
	
	public static Attack getObinoFairLeft(int skin) {
		
		return obinoFairLeft[skin];
	}
	
	public static Attack getObinoUpAirRight(int skin) {
		
		return obinoUpAirRight[skin];
	}
	
	public static Attack getObinoUpAirLeft(int skin) {
		
		return obinoUpAirLeft[skin];
	}
	
	public static Attack getObinoSideSpecialRight(int skin) {
		
		return obinoSideSpecialRight[skin];
	}
	
	public static Attack getObinoSideSpecialLeft(int skin) {
		
		return obinoSideSpecialLeft[skin];
	}
	
	public static Attack getObinoNeutralSpecialRight(int skin) {
		
		return obinoNeutralSpecialRight[skin];
	}
	
	public static Attack getObinoNeutralSpecialLeft(int skin) {
		
		return obinoNeutralSpecialLeft[skin];
	}
	
	public static Attack getObinoUpSpecialRight(int skin) {
		
		return obinoUpSpecialRight[skin];
	}
	
	public static Attack getObinoUpSpecialLeft(int skin) {
		
		return obinoUpSpecialLeft[skin];
	}
	
	public static Attack getObinoShieldingRight(int skin) {
		
		return obinoShieldingRight[skin];
	}
	
	public static Attack getObinoShieldHitRight(int skin) {
		
		return obinoShieldHitRight[skin];
	}
	
	public static Attack getObinoShieldingLeft(int skin) {
		
		return obinoShieldingLeft[skin];
	}
	
	public static Attack getObinoShieldHitLeft(int skin) {
		
		return obinoShieldHitLeft[skin];
	}
	
	public static AttackFrame getObinoParryRightFrames(int skin) {
		
		return obinoParryRightFrames[skin];
	}
	
	public static AttackFrame getObinoParryLeftFrames(int skin) {
		
		return obinoParryLeftFrames[skin];
	}
	
	
}
